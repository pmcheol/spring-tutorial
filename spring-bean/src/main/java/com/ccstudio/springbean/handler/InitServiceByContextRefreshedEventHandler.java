package com.ccstudio.springbean.handler;

import com.ccstudio.springbean.service.NameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class InitServiceByContextRefreshedEventHandler {
    private final NameService nameService;

    @EventListener
    public void handle(ContextRefreshedEvent event) {
        log.info("name = {}", nameService.getName());
    }
}
