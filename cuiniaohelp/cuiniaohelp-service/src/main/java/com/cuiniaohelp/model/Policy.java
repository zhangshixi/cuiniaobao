package com.cuiniaohelp.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created: 2017-12-18 23:58:02
 *
 * @author  Michael.Zhang
 */
@Data
public class Policy {

    private Long policyId;
    private BigDecimal policyAmount;
    private Integer period;
    private Integer payPeriod;
    private String policyDesc;

    private Insured insured;
    private Product product;
    private Plan plan;

}
