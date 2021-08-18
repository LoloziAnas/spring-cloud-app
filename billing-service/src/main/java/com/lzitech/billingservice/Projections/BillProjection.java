package com.lzitech.billingservice.Projections;

import com.lzitech.billingservice.models.Bill;
import com.lzitech.billingservice.models.ProductItem;
import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name = "fullBill",types = Bill.class)
public interface BillProjection{
    public Long getId();
    public Long getCustomerID();
    public Date getBillingDate();
    public Collection<ProductItem> getProductItems();

}
