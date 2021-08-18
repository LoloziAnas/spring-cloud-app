package com.lzitech.inventoryservice.Config;

import com.lzitech.inventoryservice.models.Product;
import com.lzitech.inventoryservice.DAO.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@Configuration
public class InventoryConfiguration {
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
