package com.cuiniaobao.service.controller;

import com.cuiniaobao.service.model.Agent;
import com.cuiniaobao.service.service.AgentService;
import com.cuiniaobao.service.vo.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created: 2018-01-12 13:55:17
 *
 * @author  Michael.Zhang
 */
@RestController
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @PostMapping("/create")
    public Object create(@RequestBody Agent agent) {
        agentService.create(agent);
        return agent.getAgentId();
    }

    @DeleteMapping("/removeById")
    public void remove(@RequestBody Long agentId) {
        agentService.removeById(agentId);
    }

    @PostMapping("/modify")
    public void modify(@RequestBody Agent agent) {
        agentService.modify(agent);
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest) {
        // TODO: check params
        agentService.login(loginRequest.getLoginName(), loginRequest.getPassword(), loginRequest.getLastLoginIp());
    }

    @PostMapping("/logout")
    public void logout(@RequestBody Long agentId) {
        // TODO: clear session
        agentService.logout(agentId);
    }

    @PostMapping("/lock")
    public void lock(@RequestBody Long agentId) {
        agentService.lockOrNotById(agentId, Boolean.TRUE);
    }

    @PostMapping("/unlock")
    public void unlock(@RequestBody Long agentId) {
        agentService.lockOrNotById(agentId, Boolean.FALSE);
    }

    @GetMapping("/findById")
    public Object selectById(@RequestBody Long agentId) {
        return agentService.findById(agentId);
    }

    @GetMapping("/queryAll")
    public Object selectAll() {
        return agentService.queryAll();
    }


}
