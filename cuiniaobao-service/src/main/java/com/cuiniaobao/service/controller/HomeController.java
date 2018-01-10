package com.cuiniaobao.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created: 2017-12-29 23:04:19
 *
 * @author  Michael.Zhang
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to cuiniaobao!";
    }

}
