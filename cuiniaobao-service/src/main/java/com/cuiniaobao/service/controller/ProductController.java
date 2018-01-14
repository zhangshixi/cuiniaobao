package com.cuiniaobao.service.controller;

import com.cuiniaobao.service.model.Product;
import com.cuiniaobao.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created: 2017-12-19 20:40:16
 *
 * @author  Michael.Zhang
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Object create(@RequestBody Product product) {
        productService.create(product);
        return product.getProductId();
    }

    @DeleteMapping("/removeById")
    public void remove(@RequestBody Long productId) {
        productService.removeById(productId);
    }

    @PostMapping("/modify")
    public void update(@RequestBody Product product) {
        productService.modify(product);
    }

    @GetMapping("/findById")
    public Object selectById(@RequestBody Long productId) {
        return productService.findById(productId);
    }

    @GetMapping("/queryByPage")
    public Object selectByPage() {
        return productService.queryByPage();
    }

}
