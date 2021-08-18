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

   @Bean
    RouteLocator staticRoutes(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder
                .routes()
                .route(r->r
                        .path("/covid/**")
                        .filters(filterSpec ->
                                filterSpec.addRequestHeader(Constants.RAPID_API_HOST,"covid-193.p.rapidapi.com")
                                .addRequestHeader(Constants.RAPID_API_KEY,"e8c7999662msh16fefc22d1dc897p1efdbejsn1e38336786e6")
                                        .rewritePath("/covid/(?<segment>.*)","/${segment}")
                                        )
                        .uri("https://covid-193.p.rapidapi.com"))
                .build();
    }
    @Bean
    DiscoveryClientRouteDefinitionLocator dynamicRoutes
            (ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp){
        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
    }
}
