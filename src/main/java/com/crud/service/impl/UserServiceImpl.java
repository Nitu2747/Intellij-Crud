package com.crud.service.impl;


import com.crud.model.User;
import com.crud.repositoy.UserRepository;
import com.crud.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserServiceI {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        User saveUser= userRepository.save(user);//cntrl+alt+v
        return saveUser;

    }

    @Override
    public User updateUser(User user, Long userId) {
        return null;
    }

    @Override
    public User getUserById(Long userId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}


