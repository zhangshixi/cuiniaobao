package com.cuiniaobao.service.service.impl;

import com.cuiniaobao.service.mapper.PlanMapper;
import com.cuiniaobao.service.model.*;
import com.cuiniaobao.service.service.*;
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
    @Autowired
    private CustomerService customerService;
    @Autowired
    private InfoService infoService;

    @Override
    public void generateByCustomer(Long customerId) {
        Customer customer = customerService.findById(customerId);
        if (customer == null) {
            return;
        }

        Info info = infoService.findByCustomerId(customerId);
        if (info == null) {
            return;
        }

        List<Insured> insuredList = insuredService.queryByCustomerId(customerId);
        if (insuredList == null) {
            return;
        }

        doGeneratePlan(info, insuredList);
    }

    private void doGeneratePlan(Info info, List<Insured> insuredList) {

    }

    @Override
    public void generateByInsured(Long insuredId) {

    }

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
