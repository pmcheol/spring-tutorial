package com.ccstudio.springbean.service.impl;

import com.ccstudio.springbean.service.NameService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile(value = "!prod")
@Primary
@Service
public class BetaNameService implements NameService {
    @Override
    public String getName() {
        return "THIS IS BETA";
    }
}
