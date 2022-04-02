package com.ccstudio.post.service.impl;

import com.ccstudio.post.dto.PostDto;
import com.ccstudio.post.repository.PostRepository;
import com.ccstudio.post.service.PostFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class PostFinderImpl implements PostFinder {
    private final PostRepository postRepository;

    @Override
    public PostDto findOne(Long id) {
        return postRepository.findById(id)
                .map(v -> PostDto.of(v.getId(), v.getTitle(), v.getContent()))
                .orElse(PostDto.fallback());
    }

    @Override
    public List<PostDto> findAll() {
        return StreamSupport.stream(postRepository.findAll().spliterator(), false)
                .map(v -> PostDto.of(v.getId(), v.getTitle(), v.getContent()))
                .collect(Collectors.toList());
    }
}
