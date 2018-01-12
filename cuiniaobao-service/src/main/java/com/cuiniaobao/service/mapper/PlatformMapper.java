package com.cuiniaobao.service.mapper;

import com.cuiniaobao.service.model.Platform;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created: 2018-01-12 14:36:38
 *
 * @author  Michael.Zhang
 */
@Mapper
public interface PlatformMapper extends BaseMapper<Platform> {

    List<Platform> selectAll();

}
