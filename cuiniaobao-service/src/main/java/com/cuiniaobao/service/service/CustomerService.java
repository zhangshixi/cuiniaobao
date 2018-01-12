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

    void modify(Customer customer);

    void removeById(Long customerId);

    Customer findById(Long customerId);

    List<Customer> queryByPage();

}
