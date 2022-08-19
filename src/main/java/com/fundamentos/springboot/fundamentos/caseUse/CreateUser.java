package com.fundamentos.springboot.fundamentos.caseUse;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {

    private UserService userService;

    public CreateUser (UserService userService){
        this.userService = userService;
    }

    public User saveUser(User newUser){
        return userService.SaveUser(newUser);
    }
}
