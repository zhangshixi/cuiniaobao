package com.cuiniaobao.service.model;

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
    private Short sex;
    private Integer age;
    private Integer insuredPeriod;
    private Integer paymentPeriod;
    private BigDecimal price;

    private Product product;

}