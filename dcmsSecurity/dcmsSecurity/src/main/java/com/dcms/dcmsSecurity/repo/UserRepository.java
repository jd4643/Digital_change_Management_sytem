package com.dcms.dcmsSecurity.repo;

import com.dcms.dcmsSecurity.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<LoginUser, Long> {
    LoginUser findByUsername(String username);
}