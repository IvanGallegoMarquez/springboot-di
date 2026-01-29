package com.ivan.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
// import org.springframework.web.context.annotation.RequestScope;
// import org.springframework.web.context.annotation.SessionScope;

import com.ivan.springboot.di.app.springboot_di.models.Product;


// @Primary

//Con RequestScope, se hace  la peticion cada vez que se llama al bean y luego se destruye
// @RequestScope

//Con SessionScope, se mantiene la misma instancia durante toda la sesion del usuario
// @SessionScope

@Primary
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {


    private List<Product> data;

    public ProductRepositoryImpl () {
    this.data = Arrays.asList(
        new Product(1L, "Corsair 32", 300L),
        new Product(2L, "Logitech Mouse", 50L),
        new Product(3L, "Asus Monitor", 400L),
        new Product(4L, "Macbook Pro", 1500L)

    );
}
//Identificamos que es una implementacion de la interfaz
@Override
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
 