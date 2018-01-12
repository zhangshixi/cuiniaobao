package com.cuiniaobao.service.controller;

import com.cuiniaobao.service.model.ProductType;
import com.cuiniaobao.service.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created: 2018-01-12 11:14:21
 *
 * @author  Michael.Zhang
 */
@RestController
@RequestMapping("/product/type")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @PostMapping("/create")
    public Object create(@RequestBody ProductType productType) {
        productTypeService.create(productType);
        return productType.getProductTypeId();
    }

    @DeleteMapping("/removeById")
    public void remove(@RequestBody Long productTypeId) {
        productTypeService.removeById(productTypeId);
    }

    @PostMapping("/modify")
    public void update(@RequestBody ProductType productType) {
        productTypeService.modify(productType);
    }

    @GetMapping("/findById")
    public Object selectById(@RequestBody Long productTypeId) {
        return productTypeService.findById(productTypeId);
    }

    @GetMapping("/queryAll")
    public Object selectAll() {
        return productTypeService.queryAll();
    }

}
