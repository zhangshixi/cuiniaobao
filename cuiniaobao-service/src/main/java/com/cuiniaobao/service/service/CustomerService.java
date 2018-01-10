package com.cuiniaobao.service.service;

import com.cuiniaobao.service.model.Customer;
import com.cuiniaobao.service.model.Insured;

import java.util.List;

/**
 * Created: 2017-12-19 20:12:27
 *
 * @author  Michael.Zhang
 */
public interface CustomerService {

    boolean createCustomer(Customer customer);

    boolean createInsured(Insured insured);

    boolean batchCreateInsureds(List<Insured> insuredList);

}
