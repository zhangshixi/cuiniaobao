package com.cuiniaobao.service.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created: 2017-12-20 17:38:53
 *
 * @author  Michael.Zhang
 */
@Data
public class Info {

    private Long infoId;
    private BigDecimal yearlySalaries;
    private BigDecimal premiumAmount;
    private Date createDate;

    private Customer customer;

}
