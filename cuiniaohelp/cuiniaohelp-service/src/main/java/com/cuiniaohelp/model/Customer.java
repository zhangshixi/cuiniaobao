package com.cuiniaohelp.model;

import lombok.Data;

/**
 * Created: 2017-12-19 00:03:35
 *
 * @author  Michael.Zhang
 */
@Data
public class Customer {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private String username;
    private String password;

}
