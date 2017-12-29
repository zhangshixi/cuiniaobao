package com.cuiniaobao.api.dao;

import com.cuiniaobao.api.model.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created: 2017-12-19 20:33:12
 *
 * @author  Michael.Zhang
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
    
}
