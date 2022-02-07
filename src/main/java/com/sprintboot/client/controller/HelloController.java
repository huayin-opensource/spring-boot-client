package com.sprintboot.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Component
public class HelloController {
    @EventListener(value = {ContextRefreshedEvent.class})
    public void init(ContextRefreshedEvent event) {
        log.info("hhh");
    }

}
