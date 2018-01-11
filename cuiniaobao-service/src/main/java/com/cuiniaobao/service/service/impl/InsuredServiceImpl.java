package com.cuiniaobao.service.service.impl;

import com.cuiniaobao.service.mapper.InsuredMapper;
import com.cuiniaobao.service.model.Insured;
import com.cuiniaobao.service.service.InsuredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created: 2017-12-29 23:09:03
 *
 * @author  Michael.Zhang
 */
@Service
public class InsuredServiceImpl implements InsuredService {

    @Autowired
    private InsuredMapper insuredMapper;

    @Override
    public void createInsured(Insured insured) {
        this.batchCreateInsureds(Arrays.asList(insured));
    }

    @Override
    public void batchCreateInsureds(List<Insured> insuredList) {
        insuredMapper.batchInsert(insuredList);
    }

    @Override
    public void modifyInsured(Insured insured) {
        insuredMapper.updateSelect(insured);
    }

    @Override
    public Insured findById(Long insuredId) {
        return insuredMapper.selectById(insuredId);
    }

    @Override
    public List<Insured> queryByCustomerId(Long customerId) {
        return insuredMapper.selectByCustomerId(customerId);
    }

}
