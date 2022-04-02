package com.ccstudio.func;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Component
public class PubSubService implements InitializingBean {
    private final RedisTemplate<String, String> redisTemplate;
    private final ScheduledExecutorService scheduledExecutorService;

    @Override
    public void afterPropertiesSet() throws Exception {
        scheduledExecutorService.schedule(() -> {
            redisTemplate.convertAndSend("channel01", "TEST_MESSAGE");
            log.info("message sent!");
        }, 5, TimeUnit.SECONDS);
    }
}
