package com.cuiniaobao.service.controller;

import com.cuiniaobao.service.model.Company;
import com.cuiniaobao.service.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created: 2017-12-19 20:25:20
 *
 * @author  Michael.Zhang
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/create")
    public Object create(@RequestBody Company company) {
        companyService.create(company);
        return company.getCompanyId();
    }

    @DeleteMapping("/removeById")
    public void remove(@RequestBody Company company) {
        companyService.removeById(company.getCompanyId());
    }

    @PutMapping("/modify")
    public void update(@RequestBody Company company) {
        companyService.modify(company);
    }

    @GetMapping("/findById")
    public Object findById(Long companyId) {
        return companyService.findById(companyId);
    }

    @GetMapping("/queryAll")
    public Object queryAll() {
        return companyService.queryAll();
    }

}
