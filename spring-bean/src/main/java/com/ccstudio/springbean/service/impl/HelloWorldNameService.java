package com.ccstudio.springbean.service.impl;

import com.ccstudio.springbean.service.NameService;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldNameService implements NameService {
    @Override
    public String getName() {
        return "Hello, World!";
    }
}
