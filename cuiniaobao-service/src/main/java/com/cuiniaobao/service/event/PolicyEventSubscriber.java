package com.cuiniaobao.service.event;

import com.cuiniaobao.service.service.PlanService;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PolicyEventSubscriber {

    @Autowired
    private PlanService planService;

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onPolicyAdded(PolicyAddEvent event) {
        planService.generateByInsured(event.getInsuredId());
    }

}