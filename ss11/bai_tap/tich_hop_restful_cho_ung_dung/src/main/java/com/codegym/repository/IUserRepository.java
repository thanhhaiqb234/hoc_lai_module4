package com.codegym.repository;

import com.codegym.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IUserRepository extends JpaRepository<Users,Long> {
    Users findByUserName(String username);
}

