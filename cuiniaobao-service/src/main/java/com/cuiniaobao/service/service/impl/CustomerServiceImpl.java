package com.cuiniaobao.service.service.impl;

import com.cuiniaobao.service.mapper.CustomerMapper;
import com.cuiniaobao.service.model.Customer;
import com.cuiniaobao.service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created: 2017-12-19 20:42:03
 *
 * @author  Michael.Zhang
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void create(Customer customer) {
        customerMapper.insert(customer);
    }

    @Override
    public void modify(Customer customer) {
        customerMapper.updateSelect(customer);
    }

    @Override
    public void removeById(Long customerId) {
        customerMapper.deleteById(customerId);
    }

    @Override
    public Customer findById(Long customerId) {
        return customerMapper.selectById(customerId);
    }

    @Override
    public List<Customer> queryByPage() {
        return customerMapper.selectByPage();
    }

}
