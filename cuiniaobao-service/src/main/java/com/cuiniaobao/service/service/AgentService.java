package com.cuiniaobao.service.service;

import com.cuiniaobao.service.model.Agent;

import java.util.List;

/**
 * Created: 2018-01-12 11:32:41
 *
 * @author  Michael.Zhang
 */
public interface AgentService {

    void create(Agent agent);

    void removeById(Long agentId);

    void modify(Agent agent);

    boolean login(String loginName, String password, String lastLoginIp);

    boolean logout(Long adminId);

    boolean lockOrNotById(Long adminId, Boolean isLocked);

    Agent findById(Long agentId);

    List<Agent> queryAll();

}
