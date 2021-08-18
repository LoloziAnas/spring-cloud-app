package com.lzitech.billingservice;

import com.lzitech.billingservice.dao.BillRepository;
import com.lzitech.billingservice.dao.ProductItemRepository;
import com.lzitech.billingservice.models.Bill;
import com.lzitech.billingservice.models.ProductItem;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository){
        return args -> {
          Bill bill1 = billRepository.save(new Bill(null, new Date(), 1L,null));
          productItemRepository.save(new ProductItem(null,1L, 500.00, 80,bill1 ));
          productItemRepository.save(new ProductItem(null,2L, 800.00, 10,bill1 ));
          productItemRepository.save(new ProductItem(null,3L, 1000.00, 50,bill1 ));
        };
    }
}
