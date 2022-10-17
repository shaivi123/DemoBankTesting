package com.springrest.DemoBankTesting.repositoryTest;

import com.springrest.DemoBankTesting.model.User;
import com.springrest.DemoBankTesting.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(value = false)
    public void saveData(){
        User user=new User(2,"Abc","XYZ",18,"abc@gmail.com",854858342,"abcA@");
        User savedUser=userRepository.save(user);
        assertNotNull(savedUser);
    }
}
