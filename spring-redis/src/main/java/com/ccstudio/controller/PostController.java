package com.ccstudio.controller;

import com.ccstudio.post.dto.PostDto;
import com.ccstudio.post.service.PostFinder;
import com.ccstudio.post.service.PostWriter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostWriter postWriter;
    private final PostFinder postFinder;

    @PostMapping(value = "/v1/api/posts")
    public void writePost(@RequestParam String title, @RequestParam String content) {
        postWriter.write(title, content);
    }

    @GetMapping(value = "/v1/api/posts")
    public CollectionDto<PostDto> findPost() {
        List<PostDto> content = postFinder.findAll();
        return new CollectionDto<>(content);
    }

    @GetMapping(value = "/v1/api/posts/{id}")
    public PostDto getPost(@PathVariable long id) {
        return postFinder.findOne(id);
    }

    @AllArgsConstructor
    @Getter
    public static class CollectionDto<T> {
        private List<T> content;
    }
}
