package com.fundamentos.springboot.fundamentos.caseUse;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {

    private UserService userService;

    public DeleteUser (UserService userService){
        this.userService = userService;
    }

    public void delete(Long id){
        this.userService.DeleteUser(id);
    }
}
