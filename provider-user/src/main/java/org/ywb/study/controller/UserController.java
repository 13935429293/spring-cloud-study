package org.ywb.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ywb.study.dao.UserRepository;
import org.ywb.study.entity.User;

/**
 * Created by Administrator on 2017/2/11.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable("id") Long id){
    return this.userRepository.findOne(id);
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user){
        return user;
    }

    @GetMapping("/get-user")
    public User getUser(User user){
        return user;
    }

    @PostMapping(value = "/user")
    public User postUser(@RequestBody User user){
        return user;
    }

    @GetMapping(value = "/get-user")
    public User getUser(User user){
        return user;
    }
}
