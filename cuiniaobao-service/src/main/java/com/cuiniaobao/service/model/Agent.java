package com.cuiniaobao.service.model;

import lombok.Data;

import java.util.Date;

/**
 * Created: 2017-12-20 17:53:56
 *
 * @author  Michael.Zhang
 */
@Data
public class Agent {

    private Long agentId;
    private String agentName;
    private String agentPhone;
    private String agentEmail;
    private String username;
    private String password;
    private Short cidType;
    private String cidNum;
    private String cidPicture;
    private Date createDate;
    private Boolean isLocked;
    private Date lastLockDate;
    private Integer loginTimes;
    private Date lastLoginDate;
    private String lastLoginIp;

}
