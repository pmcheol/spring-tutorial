package com.ccstudio.func;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class GeoService {
    private final RedisTemplate<String, String> redisTemplate;

    public long distance(double latitude, double longitude, double latitude2, double longitude2) {
        GeoOperations<String, String> geoOperations = redisTemplate.opsForGeo();

        String key = "distance";
        geoOperations.add(key, new Point(longitude, latitude), "from");
        geoOperations.add(key, new Point(longitude2, latitude2), "to");
        Distance distance = geoOperations.distance(key, "from", "to", RedisGeoCommands.DistanceUnit.METERS);

        if (distance == null)
            return 0;

        return (long) distance.getValue();
    }
}
