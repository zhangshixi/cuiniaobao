package com.cuiniaobao.service.controller;

import com.cuiniaobao.service.model.Agent;
import com.cuiniaobao.service.service.AgentService;
import com.cuiniaobao.service.api.LoginRequest;
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

    @PostMapping("/register")
    public Object register(@RequestBody Agent agent) {
        agentService.create(agent);
        return agent.getAgentId();
    }

    @DeleteMapping("/removeById")
    public void remove(@RequestBody Agent agent) {
        agentService.removeById(agent.getAgentId());
    }

    @PutMapping("/modify")
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

    @PutMapping("/lockById")
    public void lock(@RequestBody Agent agent) {
        agentService.lockOrNotById(agent.getAgentId(), Boolean.TRUE);
    }

    @PostMapping("/unlockById")
    public void unlock(@RequestBody Agent agent) {
        agentService.lockOrNotById(agent.getAgentId(), Boolean.FALSE);
    }

    @GetMapping("/findById")
    public Object findById(Long agentId) {
        return agentService.findById(agentId);
    }

    @GetMapping("/queryAll")
    public Object queryAll() {
        return agentService.queryAll();
    }


}
