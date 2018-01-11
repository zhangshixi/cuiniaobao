package com.cuiniaobao.service.event;

import org.greenrobot.eventbus.EventBus;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class EventManager {

    private static final EventBus EVENT_BUS = new EventBus();

    @PostConstruct
    public void registerSubscribers() {
        EVENT_BUS.register(new PolicyEventSubscriber());
    }

    @PreDestroy
    public void unregisterSubscribers() {
        EVENT_BUS.unregister(new PolicyEventSubscriber());
    }

    public static void post(Event event) {
        EVENT_BUS.post(event);
    }

}
