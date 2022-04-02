package com.ccstudio.metric;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Component
public class MetricWriteScheduler {
    private final RedisTemplate<String, String> redisTemplate;

    private String getKeyPrefix() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHH");
        String timeStampUntilHour = dateFormat.format(now);
        return String.format("TEST_EVENT:%s", timeStampUntilHour);
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void writeSchedule() {
        long start = System.currentTimeMillis();

        for (int i = 1000; i < 10000; i++) {
            if (i % 3 == 0) continue;
            String key = getKeyPrefix() + ":" + i;
            String value = String.valueOf(i);
            redisTemplate.opsForValue().set(key, value, 5, TimeUnit.MINUTES);
        }

        log.info("MetricWriteScheduler.writeSchedule() DONE elapsed={}ms", (System.currentTimeMillis() - start));
    }
}
