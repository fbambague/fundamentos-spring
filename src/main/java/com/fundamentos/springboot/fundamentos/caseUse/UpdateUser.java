package com.fundamentos.springboot.fundamentos.caseUse;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {

    private UserService userService;

    public UpdateUser (UserService userService){
        this.userService = userService;
    }

    public User update(User userUpdate, Long id){
        return this.userService.updateUser(userUpdate, id);
    }

}
