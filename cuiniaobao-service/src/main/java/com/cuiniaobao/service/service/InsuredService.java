package com.cuiniaobao.service.service;

import com.cuiniaobao.service.model.Insured;

import java.util.List;

/**
 * Created: 2017-12-29 21:30:14
 *
 * @author  Michael.Zhang
 */
public interface InsuredService {

    void createInsured(Insured insured);

    void batchCreateInsureds(List<Insured> insuredList);

    void modifyInsured(Insured insured);

    Insured findById(Long insuredId);

    List<Insured> queryByCustomerId(Long customerId);

}
