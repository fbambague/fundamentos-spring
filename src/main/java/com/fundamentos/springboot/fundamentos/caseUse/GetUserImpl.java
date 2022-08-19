package com.fundamentos.springboot.fundamentos.caseUse;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.service.UserService;

import java.util.List;

public class GetUserImpl implements GetUser{

    private UserService userService;

    public GetUserImpl(UserService userService){
        this.userService = userService;
    }

    @Override
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}
