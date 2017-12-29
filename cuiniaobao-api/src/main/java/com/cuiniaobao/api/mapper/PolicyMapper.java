package com.cuiniaobao.api.mapper;

import com.cuiniaobao.api.model.Policy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created: 2017-12-19 20:35:08
 *
 * @author  Michael.Zhang
 */
@Mapper
public interface PolicyMapper extends BaseMapper<Policy> {

    List<Policy> selectByPlanId(Long planId);

}
