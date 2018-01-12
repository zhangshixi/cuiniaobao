package com.cuiniaobao.service.model;

import lombok.Data;

import java.util.Date;

/**
 * Created: 2017-12-19 19:43:06
 *
 * @author  Michael.Zhang
 */
@Data
public class Admin {

    private Long adminId;
    private String adminName;
    private String adminPhone;
    private String adminEmail;
    private String username;
    private String password;
    private Date createDate;
    private Boolean isLocked;
    private Date lastLockDate;
    private Integer loginTimes;
    private Date lastLoginDate;
    private String lastLoginIp;

}
