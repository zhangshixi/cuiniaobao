package com.cuiniaobao.service.service;

import com.cuiniaobao.service.model.Product;

import java.util.List;

/**
 * Created: 2017-12-19 20:17:34
 *
 * @author  Michael.Zhang
 */
public interface ProductService {

    void create(Product product);

    void modify(Product product);

    void removeById(Long productId);

    Product findById(Long productId);

    List<Product> queryByPage();

}
