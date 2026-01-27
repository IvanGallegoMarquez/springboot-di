package com.ivan.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.ivan.springboot.di.app.springboot_di.models.Product;

public class ProductRepository {


    private List<Product> data;

    public ProductRepository() {
    this.data = Arrays.asList(
        new Product(1L, "Corsair 32", 300L),
        new Product(2L, "Logitech Mouse", 50L),
        new Product(3L, "Asus Monitor", 400L),
        new Product(4L, "Macbook Pro", 1500L)

    );
}

public List<Product> findAll() {
    return data;
}

public Product findById(Long id){
    return data.stream()
               .filter(p -> p.getId().equals(id))
               .findFirst()
               .orElse(null);
}

}
 