package com.gowthamy.userservice.repo;

import com.gowthamy.userservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo {
    void save(List<User> users);
}
