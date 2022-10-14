package com.springrest.DemoBankTesting.controller;

import com.springrest.DemoBankTesting.dto.UserReq;
import com.springrest.DemoBankTesting.model.User;
import com.springrest.DemoBankTesting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody UserReq dto){
        return userService.saveData(dto.getId(),dto.getFirstName(),dto.getLastName(),dto.getAge(),dto.getMail(),dto.getMobile(),dto.getPassword());
    }

}
