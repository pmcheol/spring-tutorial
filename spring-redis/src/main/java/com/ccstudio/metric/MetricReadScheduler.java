package com.ccstudio.metric;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@Slf4j
@RequiredArgsConstructor
@Component
public class MetricReadScheduler {
    private final RedisTemplate<String, String> redisTemplate;

    private String getKeyPrefix() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHH");
        String timeStampUntilHour = dateFormat.format(now);
        return String.format("TEST_EVENT:%s", timeStampUntilHour);
    }

    @Scheduled(cron = "5 * * * * *")
    public void metric() {
        long start = System.currentTimeMillis();

        List<String> keys = new ArrayList<>();
        for (int i = 0; i < 10000; i++)
            keys.add(String.format("%s:%d", getKeyPrefix(), i));

        Set<String> values = requireNonNull(redisTemplate.opsForValue().multiGet(keys)).stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        log.info("MetricReadScheduler.metric() keys={} values={} elapsed={}ms", keys.size(), values.size(), (System.currentTimeMillis() - start));
    }
}
