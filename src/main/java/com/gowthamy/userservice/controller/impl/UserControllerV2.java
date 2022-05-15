package com.gowthamy.userservice.controller.impl;

import com.gowthamy.userservice.controller.UserController;
import com.gowthamy.userservice.model.User;
import com.gowthamy.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/v2/")
@RestController
@Slf4j
public class UserControllerV2 implements UserController {

    private final UserService userService;

    public UserControllerV2(@Qualifier("userAsyncService") UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> save(List<User> users) {
        log.info("Request Received for creating users [{}]", users);
        return userService.save(users);
    }
}
