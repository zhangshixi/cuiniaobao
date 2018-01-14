package com.cuiniaobao.service.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created: 2017-12-19 00:03:35
 *
 * @author  Michael.Zhang
 */
@Data
public class Customer {

    private Long customerId;
    private String customerName;
    private Short customerSex;
    private String customerPhone;
    private String customerEmail;
    private Date customerBirthday;
    private String username;
    private String password;
    private Short cidType;
    private String cidNumber;
    private Date createDate;
    private Integer totalPolicyNumber;
    private BigDecimal totalPolicyAmount;
    private Integer loginTimes;
    private Date lastLoginDate;
    private String lastLoginIp;

    private Agent agent;

}
