package com.alivin.mall.tiny.controller;

import com.alivin.mall.tiny.service.ScheduledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fer
 * @date 2021/8/11
 */

@RestController
public class ScheduledController {
    @Autowired
    private ScheduledService scheduledService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        scheduledService.test();
        return "Ok";
    }
}
