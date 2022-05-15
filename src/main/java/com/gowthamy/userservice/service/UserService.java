package com.gowthamy.userservice.service;

import com.gowthamy.userservice.model.User;

import java.util.List;

public interface UserService {
    List<User> save(List<User> users);
}
