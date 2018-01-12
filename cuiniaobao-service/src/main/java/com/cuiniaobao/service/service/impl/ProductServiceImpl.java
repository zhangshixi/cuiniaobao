package com.cuiniaobao.service.service.impl;

import com.cuiniaobao.service.model.Product;
import com.cuiniaobao.service.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created: 2017-12-19 20:44:05
 *
 * @author  Michael.Zhang
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public void create(Product product) {

    }

    @Override
    public void modify(Product product) {

    }

    @Override
    public void removeById(Long productId) {

    }

    @Override
    public Product findById(Long productId) {
        return null;
    }

    @Override
    public List<Product> queryByPage() {
        return null;
    }

}
