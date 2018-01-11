package com.cuiniaobao.service.service;

import com.cuiniaobao.service.model.Policy;

import java.util.List;

/**
 * Created: 2017-12-19 20:17:57
 *
 * @author  Michael.Zhang
 */
public interface PolicyService {

    void add(Policy policy);

    List<Policy> queryByPlanId(Long planId);
    
}
