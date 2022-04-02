package com.ccstudio.post.service.impl;

import com.ccstudio.post.entity.Post;
import com.ccstudio.post.repository.PostRepository;
import com.ccstudio.post.service.PostWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostWriterImpl implements PostWriter {
    private final PostRepository postRepository;

    @Override
    public void write(String title, String text) {
        Long id = System.currentTimeMillis();
        postRepository.save(Post.of(id, title, text));
        log.info("write() id={}", id);
    }
}
