package com.cuiniaobao.service.service.impl;

import com.cuiniaobao.service.mapper.CompanyMapper;
import com.cuiniaobao.service.model.Company;
import com.cuiniaobao.service.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created: 2017-12-19 20:41:13
 *
 * @author  Michael.Zhang
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public void create(Company company) {
        companyMapper.insert(company);
    }

    @Override
    public void modify(Company company) {
        companyMapper.updateSelect(company);
    }

    @Override
    public void removeById(Long companyId) {
        companyMapper.deleteById(companyId);
    }

    @Override
    public Company findById(Long companyId) {
        return companyMapper.selectById(companyId);
    }

    @Override
    public List<Company> queryAll() {
        return companyMapper.selectAll();
    }
}
