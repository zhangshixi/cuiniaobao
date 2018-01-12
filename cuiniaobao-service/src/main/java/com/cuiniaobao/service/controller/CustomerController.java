package com.cuiniaobao.service.controller;

import com.cuiniaobao.service.model.Customer;
import com.cuiniaobao.service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created: 2017-12-19 20:24:45
 *
 * @author  Michael.Zhang
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public Object create(@RequestBody Customer customer) {
        customerService.create(customer);
        return customer.getCustomerId();
    }

    @DeleteMapping("/removeById")
    public void remove(@RequestBody Long companyId) {
        customerService.removeById(companyId);
    }

    @PostMapping("/modify")
    public void update(@RequestBody Customer customer) {
        customerService.modify(customer);
    }

    @GetMapping("/findById")
    public Object selectById(@RequestBody Long customerId) {
        return customerService.findById(customerId);
    }

    @GetMapping("/queryByPage")
    public Object selectByPage() {
        return customerService.queryByPage();
    }

}
