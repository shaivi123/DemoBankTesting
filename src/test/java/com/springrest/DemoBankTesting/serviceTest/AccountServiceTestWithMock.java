package com.springrest.DemoBankTesting.serviceTest;

import com.springrest.DemoBankTesting.exception.DatabaseWriteException;
import com.springrest.DemoBankTesting.model.Account;
import com.springrest.DemoBankTesting.repository.AccountRepository;
import com.springrest.DemoBankTesting.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTestWithMock {

    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private AccountService accountService;
    @Test
    public void sendData(){
        Account account=new Account();
        account.setId(1);
        account.setAccName("current");
        account.setBalance(1000);
        doThrow(SQLException.class).when(accountRepository).save(account);
        assertThrows(DatabaseWriteException.class, () -> accountService.addData(account));
    }
//    when(bookRepository.findAll()).thenReturn(books);

//    assertEquals(2,bookService.findNumberOfBook());

}
