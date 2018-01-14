package com.cuiniaobao.service.vo;

import lombok.Data;

/**
 * Created: 2018-01-12 20:13:13
 *
 * @author  Michael.Zhang
 */
@Data
public class LoginRequest {

    private String loginName;
    private String password;
    private String lastLoginIp;

}
