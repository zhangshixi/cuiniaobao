package com.cuiniaobao.service.service.impl;

import com.cuiniaobao.service.mapper.AgentMapper;
import com.cuiniaobao.service.model.Agent;
import com.cuiniaobao.service.service.AgentService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created: 2018-01-12 11:34:56
 *
 * @author  Michael.Zhang
 */
@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentMapper agentMapper;

    @Override
    public void create(Agent agent) {
        agentMapper.insert(agent);
    }

    @Override
    public void removeById(Long agentId) {
        agentMapper.deleteById(agentId);
    }

    @Override
    public void modify(Agent agent) {
        agentMapper.updateSelect(agent);
    }

    @Override
    public boolean login(String loginName, String password, String lastLoginIp) {
        if (Strings.isNullOrEmpty(loginName) || Strings.isNullOrEmpty(password)) {
            return false;
        }

        Agent loginAgent = agentMapper.selectByLoginName(loginName);
        if (loginAgent == null) {
            throw new RuntimeException("Agent not exist!");
        }

        if (!password.equals(loginAgent.getPassword())) {
            throw new RuntimeException("Password is error!");
        }

        if (Boolean.TRUE.equals(loginAgent.getIsLocked())) {
            throw new RuntimeException("Agent is locked!");
        }

        loginAgent.setLastLoginIp(lastLoginIp);
        agentMapper.updateLogin(loginAgent);

        return true;
    }

    @Override
    public boolean logout(Long agentId) {
        return true;
    }

    @Override
    public boolean lockOrNotById(Long agentId, Boolean isLocked) {
        if (agentId == null || isLocked == null) {
            return false;
        }
        Agent lockAgent = new Agent();
        lockAgent.setAgentId(agentId);
        lockAgent.setIsLocked(isLocked);

        agentMapper.updateLockOrNot(lockAgent);
        return true;
    }

    @Override
    public Agent findById(Long agentId) {
        return agentMapper.selectById(agentId);
    }

    @Override
    public List<Agent> queryAll() {
        return agentMapper.selectAll();
    }
}
