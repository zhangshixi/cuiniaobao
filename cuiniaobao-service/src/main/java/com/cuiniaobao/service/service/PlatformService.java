package com.cuiniaobao.service.service;

import com.cuiniaobao.service.model.Platform;

import java.util.List;

/**
 * Created: 2018-01-12 15:02:19
 *
 * @author  Michael.Zhang
 */
public interface PlatformService {

    void create(Platform platform);

    void removeById(Long platformId);

    void modify(Platform platform);

    Platform findById(Long platformId);

    List<Platform> queryAll();

}
