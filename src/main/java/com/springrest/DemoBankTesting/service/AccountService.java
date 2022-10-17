package com.springrest.DemoBankTesting.service;

import com.springrest.DemoBankTesting.model.Account;
import com.springrest.DemoBankTesting.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account saveData(long id,String accName,long balance) {
        Account account=new Account();
        account.setId(id);
        account.setAccName(accName);
        account.setBalance(balance);
        return accountRepository.save(account);
    }
    public Account findById(long id) throws AccountNotFoundException {
        Optional<Account> accountidOptional = accountRepository.findById(id);
        if (accountidOptional.isPresent()) {
            return accountidOptional.get();
        } else {
            throw new AccountNotFoundException();
        }
    }


}
