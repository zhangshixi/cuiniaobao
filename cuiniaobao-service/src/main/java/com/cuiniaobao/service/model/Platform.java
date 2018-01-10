package com.cuiniaobao.service.model;

import lombok.Data;

import java.util.Date;

/**
 * Created: 2017-12-20 18:04:39
 *
 * @author  Michael.Zhang
 */
@Data
public class Platform {

    private Long platformId;
    private String platformName;
    private String platformSite;
    private String platformDesc;
    private String platformPhone;
    private Date joinDate;
    private Date quitDate;
    private Short platformStatus;

}
