package com.ivan.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import org.springframework.core.io.ClassPathResource;

import com.ivan.springboot.di.app.springboot_di.models.Product;

import tools.jackson.core.exc.StreamReadException;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.ObjectMapper;

public class ProductRepositoryJson implements ProductRepository {


    private List<Product> list;



    public ProductRepositoryJson() {
        ClassPathResource resource = new ClassPathResource("json/product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
        list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
        } catch (StreamReadException e) {
            e.printStackTrace();
            } catch (DatabindException e) {
            e.printStackTrace();
            } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(p ->{
            return p.getId(). equals(id);
        }).findFirst().orElse(null);
    }


}
