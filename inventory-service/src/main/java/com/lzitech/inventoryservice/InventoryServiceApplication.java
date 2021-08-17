package com.lzitech.inventoryservice;

import com.lzitech.inventoryservice.models.Product;
import com.lzitech.inventoryservice.models.dao.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
          productRepository.save(new Product(null, "Clavier",15.0F));
          productRepository.save(new Product(null, "PC",100.0F));
          productRepository.save(new Product(null, "Mouse",25.0F));
          productRepository.findAll().forEach(System.out::println);
        };
    }
}
