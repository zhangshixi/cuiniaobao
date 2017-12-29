package com.cuiniaobao.api.service.impl;

import com.cuiniaobao.api.model.Customer;
import com.cuiniaobao.api.model.Insured;
import com.cuiniaobao.api.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created: 2017-12-19 20:42:03
 *
 * @author  Michael.Zhang
 */
@Service
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
