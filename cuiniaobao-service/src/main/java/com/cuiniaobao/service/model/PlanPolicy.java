package com.cuiniaobao.service.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created: 2018-01-11 14:03:43
 *
 * @author  Michael.Zhang
 */
@Data
public class PlanPolicy {

    private Long planPolicyId;
    private BigDecimal policyAmount;
    private Integer insuredPeriod;
    private Integer paymentPeriod;
    private String policyDesc;
    private Short createType;
    private Date incomeDate;
    private BigDecimal incomeAmount;
    private Platform incomePlatform;

    private Plan plan;
    private Insured insured;
    private Product product;

}
