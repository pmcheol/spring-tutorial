package com.ccstudio.func;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@ComponentScan(basePackages = "com.ccstudio.func")
@SpringBootTest
class GeoServiceTest {
    @Autowired
    private GeoService geoService;

    @Test
    public void distance() {
        long distance = geoService.distance(37.659130, 127.059698, 37.655038, 127.061119);
        log.info("distance={}", distance);
        Assertions.assertTrue(distance > 0);
    }
}
