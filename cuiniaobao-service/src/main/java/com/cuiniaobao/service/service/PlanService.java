package com.cuiniaobao.service.service;

import com.cuiniaobao.service.model.Plan;

/**
 * Created: 2017-12-19 20:16:43
 *
 * @author  Michael.Zhang
 */
public interface PlanService {

    void generateByCustomer(Long customerId);

    void generateByInsured(Long insuredId);

    Plan findById(Long planId);

    Plan findDetailsById(Long planId);

}
