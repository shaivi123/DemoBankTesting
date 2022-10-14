package com.springrest.DemoBankTesting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountReq {

    private long id;
    private String accName;
    private long balance;


}
