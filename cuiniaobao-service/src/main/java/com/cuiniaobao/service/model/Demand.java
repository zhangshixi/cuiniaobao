package com.cuiniaobao.service.model;

import lombok.Data;

import java.util.Date;

/**
 * Created: 2017-12-20 17:38:53
 *
 * @author  Michael.Zhang
 */
@Data
public class Demand {

    private Long demandId;
    private String sourceId;
    private Date createDate;
    private Byte demandStatus;

    private Customer customer;
    private Agent agent;

}
