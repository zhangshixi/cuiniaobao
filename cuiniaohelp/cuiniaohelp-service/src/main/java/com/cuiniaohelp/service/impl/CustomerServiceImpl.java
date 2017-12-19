package com.cuiniaohelp.service.impl;

import com.cuiniaohelp.model.Customer;
import com.cuiniaohelp.model.Insured;
import com.cuiniaohelp.service.CustomerService;

import java.util.List;

/**
 * Created: 2017-12-19 20:42:03
 *
 * @author  Michael.Zhang
 */
public class CustomerServiceImpl implements CustomerService {

    @Override
    public boolean createCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean createInsured(Insured insured) {
        return false;
    }

    @Override
    public boolean batchCreateInsureds(List<Insured> insuredList) {
        return false;
    }

}
