package com.cuiniaobao.service.model;

import lombok.Data;

/**
 * Created: 2017-12-18 23:56:17
 *
 * @author  Michael.Zhang
 */
@Data
public class ProductType {

    private Long productTypeId;
    private String productTypeName;
    private Integer priority;
    private Boolean isShow;

}
