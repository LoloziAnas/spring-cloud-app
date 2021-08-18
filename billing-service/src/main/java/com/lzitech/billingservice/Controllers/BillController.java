package com.lzitech.billingservice.Controllers;

import com.lzitech.billingservice.dao.BillRepository;
import com.lzitech.billingservice.dao.ProductItemRepository;
import com.lzitech.billingservice.models.Bill;
import com.lzitech.billingservice.services.CustomerService;
import com.lzitech.billingservice.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id){
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerService.findCustomerById(bill.getCustomerID()));
        bill.getProductItems().forEach(productItem -> productItem.setProduct(inventoryService.findProductById(productItem.getProductID())));
        return bill;
    }
}
