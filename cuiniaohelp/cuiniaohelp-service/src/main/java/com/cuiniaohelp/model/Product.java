package com.cuiniaohelp.model;

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
    private String buyCode;
    private String buyUrl;

    private Company company;
    private ProductType productType;
    private List<ProductRate> productRateList;

}
