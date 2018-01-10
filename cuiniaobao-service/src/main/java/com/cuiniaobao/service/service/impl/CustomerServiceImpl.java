package com.cuiniaobao.service.service.impl;

import com.cuiniaobao.service.model.Customer;
import com.cuiniaobao.service.model.Insured;
import com.cuiniaobao.service.service.CustomerService;
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
