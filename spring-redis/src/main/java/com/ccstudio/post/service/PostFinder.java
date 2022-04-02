package com.ccstudio.post.service;

import com.ccstudio.post.dto.PostDto;

import java.util.List;

public interface PostFinder {

    PostDto findOne(Long id);

    List<PostDto> findAll();
}
