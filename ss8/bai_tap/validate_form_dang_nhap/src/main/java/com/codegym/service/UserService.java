package com.codegym.service;

import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Page<User> getAllUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
}
