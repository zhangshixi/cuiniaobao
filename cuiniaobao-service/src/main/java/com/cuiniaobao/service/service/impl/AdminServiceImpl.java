package com.cuiniaobao.service.service.impl;

import com.cuiniaobao.service.mapper.AdminMapper;
import com.cuiniaobao.service.model.Admin;
import com.cuiniaobao.service.service.AdminService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created: 2018-01-12 11:33:42
 *
 * @author  Michael.Zhang
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void create(Admin admin) {
        adminMapper.insert(admin);
    }

    @Override
    public void removeById(Long adminId) {
        adminMapper.deleteById(adminId);
    }

    @Override
    public void modify(Admin admin) {
        adminMapper.updateSelect(admin);
    }

    @Override
    public boolean login(String loginName, String password, String lastLoginIp) {
        if (Strings.isNullOrEmpty(loginName) || Strings.isNullOrEmpty(password)) {
            return false;
        }

        Admin loginAdmin = adminMapper.selectByLoginName(loginName);
        if (loginAdmin == null) {
            throw new RuntimeException("Admin not exist!");
        }

        if (!password.equals(loginAdmin.getPassword())) {
            throw new RuntimeException("Password is error!");
        }

        if (Boolean.TRUE.equals(loginAdmin.getIsLocked())) {
            throw new RuntimeException("Admin is locked!");
        }

        loginAdmin.setLastLoginIp(lastLoginIp);
        adminMapper.updateLogin(loginAdmin);

        return true;
    }

    @Override
    public boolean logout(Long adminId) {
        return true;
    }

    @Override
    public boolean lockOrNotById(Long adminId, Boolean isLocked) {
        if (adminId == null || isLocked == null) {
            return false;
        }
        Admin lockAdmin = new Admin();
        lockAdmin.setAdminId(adminId);
        lockAdmin.setIsLocked(isLocked);

        adminMapper.updateLockOrNot(lockAdmin);
        return true;
    }

    @Override
    public Admin findById(Long adminId) {
        return adminMapper.selectById(adminId);
    }

    @Override
    public List<Admin> queryAll() {
        return adminMapper.selectAll();
    }

}
