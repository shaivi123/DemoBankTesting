package com.springrest.DemoBankTesting.serviceTest;

import com.springrest.DemoBankTesting.model.User;
import com.springrest.DemoBankTesting.repository.UserRepository;
import com.springrest.DemoBankTesting.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    public void setUp(){
        this.userService = new UserService(this.userRepository);
    }
    @Test
    void testSaveUser() {
        User user=new User(1,"shaivi","parmar",25,"shaivi@gmail.com",865785485,"shaivi@");
        userService.saveData(1,"shaivi","parmar",25,"shaivi@gmail.com",865785485,"shaivi@");
        verify(userRepository).save(user);
    }
    // for @Mock no need to create table in entity becoz it's dummy data
}
