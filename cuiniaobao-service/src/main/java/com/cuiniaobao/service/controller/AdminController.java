package com.cuiniaobao.service.controller;

import com.cuiniaobao.service.model.Admin;
import com.cuiniaobao.service.service.AdminService;
import com.cuiniaobao.service.vo.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created: 2018-01-12 13:55:17
 *
 * @author  Michael.Zhang
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    public Object create(@RequestBody Admin admin) {
        adminService.create(admin);
        return admin.getAdminId();
    }

    @DeleteMapping("/removeById")
    public void remove(@RequestBody Long adminId) {
        adminService.removeById(adminId);
    }

    @PostMapping("/modify")
    public void modify(@RequestBody Admin admin) {
        adminService.modify(admin);
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest) {
        // TODO: check params
        adminService.login(loginRequest.getLoginName(), loginRequest.getPassword(), loginRequest.getLastLoginIp());
    }

    @PostMapping("/logout")
    public void logout(@RequestBody Long adminId) {
        // TODO: clear session
        adminService.logout(adminId);
    }

    @PostMapping("/lock")
    public void lock(@RequestBody Long adminId) {
        adminService.lockOrNotById(adminId, Boolean.TRUE);
    }

    @PostMapping("/unlock")
    public void unlock(@RequestBody Long adminId) {
        adminService.lockOrNotById(adminId, Boolean.FALSE);
    }

    @GetMapping("/findById")
    public Object selectById(@RequestBody Long adminId) {
        return adminService.findById(adminId);
    }

    @GetMapping("/queryAll")
    public Object selectAll() {
        return adminService.queryAll();
    }

}
