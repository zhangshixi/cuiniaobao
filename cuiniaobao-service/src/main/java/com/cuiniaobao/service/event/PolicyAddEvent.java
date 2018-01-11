package com.cuiniaobao.service.event;

import lombok.Data;

@Data
public class PolicyAddEvent extends Event {

    private Long insuredId;
    private Long customerId;

    public PolicyAddEvent(Long insuredId, Long customerId) {
        this.insuredId = insuredId;
        this.customerId = customerId;
    }

}
