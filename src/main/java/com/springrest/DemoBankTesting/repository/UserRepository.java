package com.springrest.DemoBankTesting.repository;

import com.springrest.DemoBankTesting.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,Long> {


}
