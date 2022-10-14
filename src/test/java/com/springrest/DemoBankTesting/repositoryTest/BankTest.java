package com.springrest.DemoBankTesting.repositoryTest;


import com.springrest.DemoBankTesting.model.Account;
import com.springrest.DemoBankTesting.model.User;
import com.springrest.DemoBankTesting.repository.AccountRepository;
import com.springrest.DemoBankTesting.repository.UserRepository;
import com.springrest.DemoBankTesting.service.AccountService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import javax.security.auth.login.AccountNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class BankTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;

    @Test
    @Rollback(value = false)
    @Disabled
    public void saveData(){
        User user=new User(1,"shaivi","parmar",25,"shaivi@gmail.com",854858342,"Shaivi@");
        User savedUser=userRepository.save(user);
        assertNotNull(savedUser);
    }
    @Test
    @Rollback(value = false)
    public void saveAccount(){
        Account account=new Account(4,"current",1100);
        Account savedAccount=accountRepository.save(account);
        assertNotNull(savedAccount);
    }
    @BeforeEach
    void setUp()  {
    }
    @AfterEach
    void tearDown() throws Exception {
    }
    @Test
    @Rollback(value = false)
    @Disabled
    public void depositMoney() throws AccountNotFoundException {
        long amount=1000;
        long id=3;
        Account account=accountService.findById(id);
        long newBalance =  account.getBalance() + amount;
        account.setBalance(newBalance);
        accountRepository.save(account);
        assertEquals(account.getBalance(),4100,"Deposit Test");
    }

    @Test
    @Disabled
    @Rollback(value = false)
    public void withdrawMoney() throws AccountNotFoundException {
        long amount=1000;
        long id=1;
        Account account=accountService.findById(id);
        long newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        accountRepository.save(account);
        assertEquals(account.getBalance(),3100,"Withdraw Test");
    }
}
