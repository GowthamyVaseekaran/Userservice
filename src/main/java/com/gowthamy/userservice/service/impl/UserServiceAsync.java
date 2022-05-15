package com.gowthamy.userservice.service.impl;

import com.gowthamy.userservice.config.ThreadPoolConfig;
import com.gowthamy.userservice.model.User;
import com.gowthamy.userservice.repo.impl.UserFileRepository;
import com.gowthamy.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service("userAsyncService")
@Slf4j
public class UserServiceAsync implements UserService {

    private final UserFileRepository userFileRepository;

    private final ThreadPoolExecutor threadPoolExecutor;


    public UserServiceAsync(UserFileRepository userFileRepository,
                            ThreadPoolConfig threadPoolConfig) {
        this.userFileRepository = userFileRepository;
        this.threadPoolExecutor =  new ThreadPoolExecutor(threadPoolConfig.getSize(),
                threadPoolConfig.getMaxPoolSize(),
                threadPoolConfig.getKeepAliveTimeInMinutes(),
                TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(threadPoolConfig.getQueueSize()),
                new ThreadPoolExecutor.AbortPolicy());
    }

    @Override
    public List<User> save(List<User> users) {
        threadPoolExecutor.submit(() -> userFileRepository.save(users));
        log.info("save users task submitted for [{}]", users);
        return users;
    }
}
