package com.cuiniaobao.service.controller;

import com.cuiniaobao.service.model.Customer;
import com.cuiniaobao.service.service.CustomerService;
import com.cuiniaobao.service.api.LoginRequest;
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

    @PostMapping("/register")
    public Object register(@RequestBody Customer customer) {
        customerService.create(customer);
        return customer.getCustomerId();
    }

    @DeleteMapping("/removeById")
    public void remove(@RequestBody Customer customer) {
        customerService.removeById(customer.getCustomerId());
    }

    @PutMapping("/modify")
    public void update(@RequestBody Customer customer) {
        customerService.modify(customer);
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest) {
        // TODO: check params
        customerService.login(loginRequest.getLoginName(), loginRequest.getPassword(), loginRequest.getLastLoginIp());
    }

    @PostMapping("/logout")
    public void logout(@RequestBody Long agentId) {
        // TODO: clear session
        customerService.logout(agentId);
    }

    @GetMapping("/findById")
    public Object findById(@RequestBody Long customerId) {
        return customerService.findById(customerId);
    }

    @GetMapping("/queryByPage")
    public Object queryByPage() {
        return customerService.queryByPage();
    }

}
