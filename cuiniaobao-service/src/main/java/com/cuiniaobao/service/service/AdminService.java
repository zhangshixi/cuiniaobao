package com.cuiniaobao.service.service;

import com.cuiniaobao.service.model.Admin;

import java.util.List;

/**
 * Created: 2018-01-12 11:30:23
 *
 * @author  Michael.Zhang
 */
public interface AdminService {

    void create(Admin admin);

    void removeById(Long adminId);

    void modify(Admin admin);

    boolean login(String loginName, String password, String lastLoginIp);

    boolean logout(Long adminId);

    boolean lockOrNotById(Long adminId, Boolean isLocked);

    Admin findById(Long adminId);

    List<Admin> queryAll();

}
