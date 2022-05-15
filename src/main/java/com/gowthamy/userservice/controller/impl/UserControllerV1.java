package com.gowthamy.userservice.controller.impl;

import com.gowthamy.userservice.controller.UserController;
import com.gowthamy.userservice.model.User;
import com.gowthamy.userservice.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/v1/")
@RestController
@Slf4j
public class UserControllerV1 implements UserController {

    private final UserServiceImpl userServiceImpl;

    public UserControllerV1(@Qualifier("userServiceImpl") UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public List<User> save(List<User> users) {
        log.info("Request Received for creating users [{}]", users);
        return userServiceImpl.save(users);
    }
}
