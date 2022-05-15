package com.gowthamy.userservice.service.impl;

import com.gowthamy.userservice.model.User;
import com.gowthamy.userservice.repo.impl.UserFileRepository;
import com.gowthamy.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    UserFileRepository userFileRepository;

    public UserServiceImpl(UserFileRepository userFileRepository) {
        this.userFileRepository = userFileRepository;
    }

    public List<User> save(List<User> users) {
        userFileRepository.save(users);
        return users;
    }

}
