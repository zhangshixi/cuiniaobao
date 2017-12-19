package com.cuiniaohelp.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created: 2017-12-19 00:02:33
 *
 * @author  Michael.Zhang
 */
@Data
public class Plan {

    private Long planId;
    private String planName;

    private Customer customer;
    private List<Policy> policyList;

    public Map<Insured, List<Policy>> getInsuredPolicyListMap() {
        return null;
    }

}
