package com.cuiniaobao.service.service.impl;

import com.cuiniaobao.service.mapper.PlatformMapper;
import com.cuiniaobao.service.model.Platform;
import com.cuiniaobao.service.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created: 2018-01-12 15:02:51
 *
 * @author  Michael.Zhang
 */
@Service
public class PlatformServiceImpl implements PlatformService {

    @Autowired
    private PlatformMapper platformMapper;

    @Override
    public void create(Platform platform) {
        platformMapper.insert(platform);
    }

    @Override
    public void modify(Platform platform) {
        platformMapper.updateSelect(platform);
    }

    @Override
    public void removeById(Long platformId) {
        platformMapper.deleteById(platformId);
    }

    @Override
    public Platform findById(Long platformId) {
        return platformMapper.selectById(platformId);
    }

    @Override
    public List<Platform> queryAll() {
        return platformMapper.selectAll();
    }
}
