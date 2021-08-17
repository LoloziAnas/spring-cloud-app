package com.lzitech.getewayservice;

import com.lzitech.getewayservice.Utils.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    private static final String LB_CUSTOMER_SERVICE = "lb://CUSTOMER-SERVICE";
    private static final String LB_INVENTORY_SERVICE = "lb://INVENTORY-SERVICE";
    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

/*    @Bean
    RouteLocator staticRoutes(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder
                .routes()
                .route(r->r.path(Constants.CUSTOMERS_PATH).uri(LB_CUSTOMER_SERVICE))
                .route(r->r.path(Constants.PRODUCTS_PATH).uri(LB_INVENTORY_SERVICE))
                .build();
    }*/
    @Bean
    DiscoveryClientRouteDefinitionLocator dynamicRoutes
            (ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp){
        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
    }
}
