package com.cuiniaobao.service.model;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created: 2017-12-19 00:02:33
 *
 * @author  Michael.Zhang
 */
@Data
public class Plan {

    private Long planId;
    private String planName;
    private Short planStatus;
    private Date createDate;

    private Info demand;
    private Customer customer;
    private List<Policy> policyList;
    private Agent agent;

    public Map<Insured, List<Policy>> getInsuredPolicyListMap() {
        if (CollectionUtils.isEmpty(getPolicyList())) {
            return Collections.emptyMap();
        }

        final Map<Insured, List<Policy>> returnMap = new HashMap<>();
        getPolicyList().forEach(policy -> {
            List<Policy> list = returnMap.get(policy);
            list = list == null ? new ArrayList<>() : list;
            list.add(policy);
            returnMap.put(policy.getInsured(), list);
        });

        return returnMap;
    }

}
