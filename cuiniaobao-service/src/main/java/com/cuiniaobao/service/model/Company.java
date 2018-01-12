package com.cuiniaobao.service.model;

import lombok.Data;

import java.util.Date;

/**
 * Created: 2017-12-18 23:53:56
 *
 * @author  Michael.Zhang
 */
@Data
public class Company {

    private Long companyId;
    private String companyName;
    private String companyPhone;
    private String companySite;
    private String companyDesc;
    private String priority;
    private Date createDate;

}
