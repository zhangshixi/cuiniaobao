package com.cuiniaobao.api.controller;

import com.cuiniaobao.api.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created: 2017-12-19 20:39:36
 *
 * @author  Michael.Zhang
 */
@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping("/{planId}")
    public Object findPlanById(@PathVariable("planId") Long planId) {
        System.err.println("p=======" + planId);
        return planService.findById(planId);
    }



}
