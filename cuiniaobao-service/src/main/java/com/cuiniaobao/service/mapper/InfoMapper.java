package com.cuiniaobao.service.mapper;

import com.cuiniaobao.service.model.Info;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created: 2018-01-12 14:36:38
 *
 * @author  Michael.Zhang
 */
@Mapper
public interface InfoMapper extends BaseMapper<Info> {

    Info selectByCustomerId(Long customerId);

}
