package com.springrest.DemoBankTesting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserReq {

    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String mail;
    private long mobile;
    private String password;
}
