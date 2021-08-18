package com.lzitech.billingservice;

import com.lzitech.billingservice.dao.BillRepository;
import com.lzitech.billingservice.models.Customer;
import com.lzitech.billingservice.dao.ProductItemRepository;
import com.lzitech.billingservice.models.Bill;
import com.lzitech.billingservice.models.Product;
import com.lzitech.billingservice.models.ProductItem;
import com.lzitech.billingservice.services.CustomerService;
import com.lzitech.billingservice.services.InventoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerService customerService, InventoryService inventoryService){
        return args -> {
            Customer customer = customerService.findCustomerById(1L);
            Bill bill1 = billRepository.save(new Bill(null, new Date(), customer.getId(),null,null));
            PagedModel<Product> products = inventoryService.findAllProducts();
            products.getContent().forEach(
                    product ->productItemRepository.save(new ProductItem(null, product.getId(), null,product.getPrice(), product.getQuantity(),bill1 )
                    ));

        };
    }
}
