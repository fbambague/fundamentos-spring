package com.fundamentos.springboot.fundamentos.controller;

import com.fundamentos.springboot.fundamentos.caseUse.*;
import com.fundamentos.springboot.fundamentos.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private GetUser getUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    private CreateUser createUser;

    public UserRestController(GetUser getUser,
                              DeleteUser deleteUser,
                              UpdateUser updateUser,
                              CreateUser createUser){
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }

    @GetMapping("/")
    public List<User> get(){
        return getUser.getUsers();
    }

    @PostMapping("/add")
    public ResponseEntity<User> newUser(@RequestBody User user){
        User newUser = this.createUser.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        this.deleteUser.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long id){
        User updateUser = this.updateUser.update(user,id);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }





}
