package com.lzitech.inventoryservice;

import com.lzitech.inventoryservice.dao.ProductRepository;
import com.lzitech.inventoryservice.models.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Product.class);
          productRepository.save(new Product(null, "Clavier",15.0F));
          productRepository.save(new Product(null, "PC",100.0F));
          productRepository.save(new Product(null, "Mouse",25.0F));
        };
    }
}
