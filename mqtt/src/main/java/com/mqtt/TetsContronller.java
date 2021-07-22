package com.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/run")
public class TetsContronller {
//    @Autowired
//    private TestMqttService service;
//
//    @GetMapping()
//    public void init() {
//        service.init();
//    }

    @Autowired
    private Ouvinte service;

    @GetMapping()
    public void init() {
        service.init();
    }
}
