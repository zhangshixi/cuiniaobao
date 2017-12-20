package com.cuiniaohelp.model;

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
    private String platformUrl;
    private String platformDesc;
    private Date joinDate;
    private Date quitDate;
    private String manageName;
    private Short platformStatus;

}
