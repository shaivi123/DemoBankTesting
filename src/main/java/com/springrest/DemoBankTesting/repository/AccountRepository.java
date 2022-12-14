package com.springrest.DemoBankTesting.repository;

import com.springrest.DemoBankTesting.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {


    Account findAccountById(int accountId);
}
