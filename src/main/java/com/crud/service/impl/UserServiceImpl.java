package com.crud.service.impl;


import com.crud.model.User;
import com.crud.repositoy.UserRepository;
import com.crud.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        User user1 = userRepository.findById(userId).get();
        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setUserAbout(user.getUserAbout());

        User updatedUser = userRepository.save(user1);

        return updatedUser;
    }

    @Override
    public User getUserById(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Resource Not Found On Server"));
        return  user;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}


