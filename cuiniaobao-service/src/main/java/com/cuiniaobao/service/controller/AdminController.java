package com.cuiniaobao.service.controller;

import com.cuiniaobao.service.model.Admin;
import com.cuiniaobao.service.service.AdminService;
import com.cuiniaobao.service.api.LoginRequest;
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
    public void remove(@RequestBody Admin admin) {
        adminService.removeById(admin.getAdminId());
    }

    @PutMapping("/modify")
    public void modify(@RequestBody Admin admin) {
        adminService.modify(admin);
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest) {
        // TODO: check params
        adminService.login(loginRequest.getLoginName(), loginRequest.getPassword(), loginRequest.getLastLoginIp());
    }

    @PostMapping("/logout")
    public void logout(@RequestBody Admin admin) {
        // TODO: clear session
        adminService.logout(admin.getAdminId());
    }

    @PutMapping("/lockById")
    public void lock(@RequestBody Admin admin) {
        adminService.lockOrNotById(admin.getAdminId(), Boolean.TRUE);
    }

    @PutMapping("/unlockById")
    public void unlock(@RequestBody Admin admin) {
        adminService.lockOrNotById(admin.getAdminId(), Boolean.FALSE);
    }

    @GetMapping("/findById")
    public Object findById(Long adminId) {
        return adminService.findById(adminId);
    }

    @GetMapping("/queryAll")
    public Object queryAll() {
        return adminService.queryAll();
    }

}
