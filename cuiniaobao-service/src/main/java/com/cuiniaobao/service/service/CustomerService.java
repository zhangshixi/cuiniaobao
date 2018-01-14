package com.cuiniaobao.service.service;

import com.cuiniaobao.service.model.Customer;

import java.util.List;

/**
 * Created: 2017-12-19 20:12:27
 *
 * @author  Michael.Zhang
 */
public interface CustomerService {

    void create(Customer customer);

    void removeById(Long customerId);

    void modify(Customer customer);

    boolean login(String loginName, String password, String lastLoginIp);

    boolean logout(Long agentId);

    Customer findById(Long customerId);

    List<Customer> queryByPage();

}
