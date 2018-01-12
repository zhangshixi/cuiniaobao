package com.cuiniaobao.service.mapper;

import com.cuiniaobao.service.model.ProductType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created: 2017-12-19 20:37:46
 *
 * @author  Michael.Zhang
 */
@Mapper
public interface ProductTypeMapper extends BaseMapper<ProductType> {

    List<ProductType> selectAll();

}
