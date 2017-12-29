package com.cuiniaobao.api.service;

import com.cuiniaobao.api.model.Policy;

import java.util.List;

/**
 * Created: 2017-12-19 20:17:57
 *
 * @author  Michael.Zhang
 */
public interface PolicyService {

    List<Policy> queryByPlanId(Long planId);
    
}
