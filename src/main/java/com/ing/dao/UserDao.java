package com.ing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.entity.Account;

@Repository
public interface UserDao extends JpaRepository<Account, Integer> {

}
