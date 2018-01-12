package com.cuiniaobao.service.service;

import com.cuiniaobao.service.model.Info;

/**
 * Created: 2017-12-19 20:16:43
 *
 * @author  Michael.Zhang
 */
public interface InfoService {

    void create(Info info);

    void removeById(Long infoId);

    void modify(Info info);

    Info findById(Long infoId);

    Info findByCustomerId(Long customerId);

}
