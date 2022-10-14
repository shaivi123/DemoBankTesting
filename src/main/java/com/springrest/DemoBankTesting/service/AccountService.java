package com.springrest.DemoBankTesting.service;

import com.springrest.DemoBankTesting.model.Account;
import com.springrest.DemoBankTesting.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account findById(long id) throws AccountNotFoundException {
        Optional<Account> accountidOptional = accountRepository.findById(id);
        if (accountidOptional.isPresent()) {
            return accountidOptional.get();
        } else {
            throw new AccountNotFoundException();
        }
    }
}
