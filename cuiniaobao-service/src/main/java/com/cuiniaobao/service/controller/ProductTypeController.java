package com.cuiniaobao.service.controller;

import com.cuiniaobao.service.model.Admin;
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
    public void remove(@RequestBody ProductType productType) {
        productTypeService.removeById(productType.getProductTypeId());
    }

    @PutMapping("/modify")
    public void update(@RequestBody ProductType productType) {
        productTypeService.modify(productType);
    }
    @PutMapping("/showById")
    public void lock(@RequestBody ProductType productType) {
        productTypeService.showOrNotById(productType.getProductTypeId(), Boolean.TRUE);
    }

    @PutMapping("/hideById")
    public void unlock(@RequestBody ProductType productType) {
        productTypeService.showOrNotById(productType.getProductTypeId(), Boolean.FALSE);
    }


    @GetMapping("/findById")
    public Object selectById(Long productTypeId) {
        return productTypeService.findById(productTypeId);
    }

    @GetMapping("/queryAll")
    public Object selectAll(Boolean isShow) {
        return productTypeService.queryAll(isShow);
    }

}
