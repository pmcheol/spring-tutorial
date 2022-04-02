package com.ccstudio.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
public class PostDto {
    private Long id;
    private String title;
    private String content;

    public static PostDto fallback() {
        return new PostDto();
    }
}
