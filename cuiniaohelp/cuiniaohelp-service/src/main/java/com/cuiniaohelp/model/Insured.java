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

    private Long id;
    private String name;
    private Byte sex;
    private Date birthday;
    private String phone;
    private Byte cidType;
    private String cidNum;

}
