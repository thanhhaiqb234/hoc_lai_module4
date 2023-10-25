package com.codegym.service;

import com.codegym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> getAllUser(Pageable pageable);

    void createUser(User user);
}
