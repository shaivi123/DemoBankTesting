package com.springrest.DemoBankTesting.service;


import com.springrest.DemoBankTesting.model.Account;
import com.springrest.DemoBankTesting.model.User;
import com.springrest.DemoBankTesting.repository.AccountRepository;
import com.springrest.DemoBankTesting.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {


    @Mock
    private AccountRepository accountRepository;
    private  AccountService accountService;
    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    public void setUp(){
        this.accountService = new AccountService(this.accountRepository);
        this.userService = new UserService(this.userRepository);
    }
    @Test
    void saveAccountTest() {
        Account account=new Account(4,"current",1100);
       accountService.saveData(4,"current",1100);
       verify(accountRepository).save(account);
    }
    // for @Mock no need to create table in entity becoz it's dummy data

    @Test
    void testSaveUser() {
        User user=new User(1,"shaivi","parmar",25,"shaivi@gmail.com",865785485,"shaivi@");
        userService.saveData(1,"shaivi","parmar",25,"shaivi@gmail.com",865785485,"shaivi@");
        verify(userRepository).save(user);
    }
}
