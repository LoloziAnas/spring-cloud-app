package com.lzitech.getewayservice;

import com.lzitech.getewayservice.Utils.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    @Bean
    RouteLocator staticRoutes(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder
                .routes()
                .route(r->r.path(Constants.CUSTOMERS_PATH).uri(Constants.CUSTOMERS_URI))
                .route(r->r.path(Constants.PRODUCTS_PATH).uri(Constants.PRODUCTS_URI))
                .build();
    }
}
