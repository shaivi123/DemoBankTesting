package com.springrest.DemoBankTesting.service;

import com.springrest.DemoBankTesting.model.User;
import com.springrest.DemoBankTesting.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;


    public User saveData(long id, String firstName, String lastName, int age, String mail, long mobile, String password) {
        User user=new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setMail(mail);
        user.setMobile(mobile);
        user.setPassword(password);
        return userRepository.save(user);
    }
}
