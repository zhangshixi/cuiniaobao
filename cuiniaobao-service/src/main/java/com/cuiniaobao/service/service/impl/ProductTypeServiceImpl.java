package com.cuiniaobao.service.service.impl;

import com.cuiniaobao.service.mapper.ProductTypeMapper;
import com.cuiniaobao.service.model.ProductType;
import com.cuiniaobao.service.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created: 2018-01-12 11:10:25
 *
 * @author  Michael.Zhang
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public void create(ProductType productType) {
        productTypeMapper.insert(productType);
    }

    @Override
    public void modify(ProductType productType) {
        productTypeMapper.updateSelect(productType);
    }

    @Override
    public void removeById(Long productTypeId) {
        productTypeMapper.deleteById(productTypeId);
    }

    @Override
    public ProductType findById(Long productTypeId) {
        return productTypeMapper.selectById(productTypeId);
    }

    @Override
    public List<ProductType> queryAll() {
        return productTypeMapper.selectAll();
    }

}
