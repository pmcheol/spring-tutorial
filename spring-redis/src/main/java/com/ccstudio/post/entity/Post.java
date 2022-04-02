package com.ccstudio.post.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@AllArgsConstructor(staticName = "of")
@RedisHash(value = "Post")
@Getter
public class Post {
    @Id
    private Long id;
    private String title;
    private String content;
}
