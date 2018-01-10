package com.cuiniaobao.service.model;

import lombok.Data;

import java.util.List;

/**
 * Created: 2017-12-18 23:55:56
 *
 * @author  Michael.Zhang
 */
@Data
public class Product {

    private Long productId;
    private String productName;
    private String productDesc;
    private String buyUrl;
    private String buyCode;

    private Company company;
    private ProductType productType;
    private List<ProductRate> productRateList;

}
