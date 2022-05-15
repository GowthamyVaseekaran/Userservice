package com.gowthamy.userservice.controller;


import com.gowthamy.userservice.model.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@RestController
@RequestMapping("default/")
@Validated
public interface UserController {

    @PostMapping(value = "user")
    List<User> save(@RequestBody @NotEmpty List<@Valid User> users);
}
