package com.cuiniaobao.service.controller;

import com.cuiniaobao.service.model.Platform;
import com.cuiniaobao.service.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created: 2017-12-19 20:25:20
 *
 * @author  Michael.Zhang
 */
@RestController
@RequestMapping("/platform")
public class PlatformController {

    @Autowired
    private PlatformService platformService;

    @PostMapping("/create")
    public Object create(@RequestBody Platform platform) {
        platformService.create(platform);
        return platform.getPlatformId();
    }

    @DeleteMapping("/removeById")
    public void remove(@RequestBody Platform platform) {
        platformService.removeById(platform.getPlatformId());
    }

    @PutMapping("/modify")
    public void update(@RequestBody Platform platform) {
        platformService.modify(platform);
    }

    @GetMapping("/findById")
    public Object selectById(Long platformId) {
        return platformService.findById(platformId);
    }

    @GetMapping("/queryAll")
    public Object selectAll() {
        return platformService.queryAll();
    }

}
