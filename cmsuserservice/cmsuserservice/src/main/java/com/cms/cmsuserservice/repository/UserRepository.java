package com.cms.cmsuserservice.repository;

import com.cms.cmsuserservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByAccountNumber(String accountNumber);
    Optional<User> findById(long id);
    List<User> findAll();

    boolean existsByAccountNumber(String accountNumbers);



}