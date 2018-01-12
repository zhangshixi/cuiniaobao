package com.cuiniaobao.service.service.impl;

import com.cuiniaobao.service.mapper.InfoMapper;
import com.cuiniaobao.service.model.Info;
import com.cuiniaobao.service.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created: 2017-12-29 19:52:50
 *
 * @author  Michael.Zhang
 */
@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public void create(Info info) {
        infoMapper.insert(info);
    }

    @Override
    public void removeById(Long infoId) {
        infoMapper.deleteById(infoId);
    }

    @Override
    public void modify(Info info) {
        infoMapper.updateSelect(info);
    }

    @Override
    public Info findById(Long infoId) {
        return infoMapper.selectById(infoId);
    }

    @Override
    public Info findByCustomerId(Long customerId) {
        return infoMapper.selectByCustomerId(customerId);
    }
}
