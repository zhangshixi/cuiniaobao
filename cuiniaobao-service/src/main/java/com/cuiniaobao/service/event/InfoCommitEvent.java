package com.cuiniaobao.service.event;

import lombok.Data;

/**
 * Created: 2018-01-14 13:35:53
 *
 * @author  Michael.Zhang
 */
@Data
public class InfoCommitEvent extends Event {

    private Long customerId;

    public InfoCommitEvent(Long customerId) {
        this.customerId = customerId;
    }

}
