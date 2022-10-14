package com.springrest.DemoBankTesting.model;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "accounts" )

public class Account {

    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String accName;
    private long balance;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accName='" + accName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
