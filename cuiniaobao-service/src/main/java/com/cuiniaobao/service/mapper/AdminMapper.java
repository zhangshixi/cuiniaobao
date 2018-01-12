package com.cuiniaobao.service.mapper;

import com.cuiniaobao.service.model.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created: 2017-12-19 20:38:37
 *
 * @author  Michael.Zhang
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    void updateLogin(Admin admin);

    void updateLockOrNot(Admin admin);

    Admin selectByLoginName(String loginName);

    List<Admin> selectAll();

}
