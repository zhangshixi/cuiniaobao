package com.cuiniaobao.api.service.impl;

import com.cuiniaobao.api.mapper.PlanMapper;
import com.cuiniaobao.api.model.Plan;
import com.cuiniaobao.api.model.Policy;
import com.cuiniaobao.api.service.InsuredService;
import com.cuiniaobao.api.service.PlanService;
import com.cuiniaobao.api.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created: 2017-12-19 20:42:40
 *
 * @author  Michael.Zhang
 */
@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanMapper planMapper;

    @Autowired
    private PolicyService policyService;
    @Autowired
    private InsuredService insuredService;

    @Override
    public Plan findById(Long planId) {
        return planMapper.selectById(planId);
    }

    @Override
    public Plan findDetailsById(Long planId) {
        Plan plan = planMapper.selectById(planId);
        if (plan == null) {
            return plan;
        }

        List<Policy> policyList = policyService.queryByPlanId(planId);
        plan.setPolicyList(policyList);

        return plan;
    }

}
