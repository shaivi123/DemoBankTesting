package com.springrest.DemoBankTesting.serviceTest;


import com.springrest.DemoBankTesting.exception.InvalidAvailabilityException;
import com.springrest.DemoBankTesting.model.Account;
import com.springrest.DemoBankTesting.model.User;
import com.springrest.DemoBankTesting.repository.AccountRepository;
import com.springrest.DemoBankTesting.repository.UserRepository;
import com.springrest.DemoBankTesting.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.security.auth.login.AccountNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AccountServiceTest {
   @Autowired
   //@Mock
    private AccountRepository accountRepository;
   @Autowired
    private AccountService accountService;
    @BeforeEach
    public void setUp(){
        this.accountService = new AccountService(this.accountRepository);
    }
    @Test
    void saveAccountTest() {
        Account account=new Account(4,"current",1100);
       accountService.saveData(4,"current",1100);
       verify(accountRepository).save(account);
    }
    // for @Mock no need to create table in entity becoz it's dummy data
    //edge cases means one type of validation which is not accept of negative values
    //The edge case is inputs approach limits or outside limits

    @Test
//  @Disabled
    @Rollback(value = false)
    public void withdrawMoney() throws AccountNotFoundException {
        long amount=1000;
        long id=3;
        if(amount<=0){
            throw new InvalidAvailabilityException("The amount can not be less than or equal to zero");
        }else {
            Account account = accountService.findById(id);
            long newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);
            accountRepository.save(account);
            assertEquals(account.getBalance(), 5000, "Withdraw Test");
        }
    }
     @Test
     @Rollback(value = false)
//   @Disabled
     public void depositMoney() throws AccountNotFoundException {
        long amount=1000;
        long id=4;
        if(amount<=0){
            throw new InvalidAvailabilityException("The amount can not be less than or equal to zero");
        }else {
            Account account = accountService.findById(id);
            long newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            accountRepository.save(account);
            assertEquals(account.getBalance(), 100, "Deposit Test");
        }
     }



}
