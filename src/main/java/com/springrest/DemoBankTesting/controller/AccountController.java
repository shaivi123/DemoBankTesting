package com.springrest.DemoBankTesting.controller;


import com.springrest.DemoBankTesting.dto.AccountReq;
import com.springrest.DemoBankTesting.model.Account;
import com.springrest.DemoBankTesting.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/saveData")
    public Account saveData(@RequestBody AccountReq dto){
      return  accountService.saveData(dto.getId(),dto.getAccName(),dto.getBalance());
    }
}
