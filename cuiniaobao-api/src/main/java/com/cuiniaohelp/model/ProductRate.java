package com.cuiniaohelp.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created: 2017-12-18 23:57:02
 *
 * @author  Michael.Zhang
 */
@Data
public class ProductRate {

    private Long productRateId;
    private Byte sex;
    private Integer age;
    private Integer payPeriod;
    private Integer period;
    private BigDecimal premium;

    private Product product;

}