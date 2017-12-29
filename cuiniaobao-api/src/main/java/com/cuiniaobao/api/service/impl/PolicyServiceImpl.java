package com.cuiniaobao.api.service.impl;

import com.cuiniaobao.api.dao.PolicyMapper;
import com.cuiniaobao.api.model.Policy;
import com.cuiniaobao.api.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created: 2017-12-19 20:43:31
 *
 * @author  Michael.Zhang
 */
@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyMapper policyMapper;

    @Override
    public List<Policy> queryByPlanId(Long planId) {
        return policyMapper.selectByPlanId(planId);
    }

}
