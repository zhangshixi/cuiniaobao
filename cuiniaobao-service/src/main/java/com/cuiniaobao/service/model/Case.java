package com.cuiniaobao.service.model;

import lombok.Data;

import java.util.Date;

/**
 * Created: 2018-01-17 17:19:42
 *
 * @author  Michael.Zhang
 */
@Data
public class Case {

    private Long caseId;
    private String caseSummary;
    private String caseContent;
    private Integer priority;
    private Date createDate;

}
