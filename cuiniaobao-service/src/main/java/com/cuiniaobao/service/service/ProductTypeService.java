package com.cuiniaobao.service.service;

import com.cuiniaobao.service.model.ProductType;

import java.util.List;

/**
 * Created: 2018-01-12 11:08:54
 *
 * @author  Michael.Zhang
 */
public interface ProductTypeService {

    void create(ProductType productType);

    void modify(ProductType productType);

    void removeById(Long productTypeId);

    ProductType findById(Long productTypeId);

    List<ProductType> queryAll();

}
