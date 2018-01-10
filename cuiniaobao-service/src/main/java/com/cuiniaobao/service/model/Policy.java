package com.cuiniaobao.service.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created: 2017-12-18 23:58:02
 *
 * @author  Michael.Zhang
 */
@Data
public class Policy {

    private Long policyId;
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
