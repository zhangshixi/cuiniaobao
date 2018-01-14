package com.cuiniaobao.service.service.impl;

import com.cuiniaobao.service.mapper.CustomerMapper;
import com.cuiniaobao.service.model.Agent;
import com.cuiniaobao.service.model.Customer;
import com.cuiniaobao.service.service.CustomerService;
import com.google.common.base.Strings;
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
    public void removeById(Long customerId) {
        customerMapper.deleteById(customerId);
    }

    @Override
    public void modify(Customer customer) {
        customerMapper.updateSelect(customer);
    }

    @Override
    public boolean login(String loginName, String password, String lastLoginIp) {
        if (Strings.isNullOrEmpty(loginName) || Strings.isNullOrEmpty(password)) {
            return false;
        }

        Customer loginCustomer = customerMapper.selectByLoginName(loginName);
        if (loginCustomer == null) {
            throw new RuntimeException("Agent not exist!");
        }

        if (!password.equals(loginCustomer.getPassword())) {
            throw new RuntimeException("Password is error!");
        }

        loginCustomer.setLastLoginIp(lastLoginIp);
        customerMapper.updateLogin(loginCustomer);

        return true;
    }

    @Override
    public boolean logout(Long agentId) {
        return true;
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
