package com.lzitech.customerservice.Projections;

import com.lzitech.customerservice.models.Customer;
import org.springframework.data.rest.core.config.Projection;
@Projection(name = "p1", types = Customer.class)
public interface CustomerProjection extends Projection {
    public Long getId();
    public String getName();
    public String getPhone();
}
