package com.cuiniaobao.service.service;

import com.cuiniaobao.service.model.Company;

import java.util.List;

/**
 * Created: 2017-12-19 20:18:54
 *
 * @author  Michael.Zhang
 */
public interface CompanyService {

    void create(Company company);

    void modify(Company company);

    void removeById(Long companyId);

    Company findById(Long companyId);

    List<Company> queryAll();

}
