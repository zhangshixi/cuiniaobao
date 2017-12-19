package com.cuiniaohelp.model;

import lombok.Data;

import java.util.Date;

/**
 * Created: 2017-12-19 00:00:11
 *
 * @author  Michael.Zhang
 */
@Data
public class Insured {

    private Long insuredId;
    private String insuredName;
    private Byte insuredSex;
    private Date insuredBirthday;
    private String insuredPhone;
    private Byte cidType;
    private String cidNum;

}
