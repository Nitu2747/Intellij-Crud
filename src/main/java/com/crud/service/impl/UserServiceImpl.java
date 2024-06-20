package com.crud.service.impl;
import com.crud.model.User;
import com.crud.repositoy.UserRepository;
import com.crud.service.UserServiceI;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserServiceI {

   // Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        log.info("Initiating the dao call to save user");
        User saveUser = userRepository.save(user);//cntrl+alt+v
        log.info("Request to dao got completed to save data");
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
      log.info("Initiate dao call to get single user data with this userId{}  ",userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Resource Not Found On Server"));
        log.info("Completed dao call to get single user data with this userId{}  ",userId);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUser = userRepository.findAll();
        return allUser;
    }


    @Override
    public void deleteUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Resource Not Found On Server"));
        userRepository.delete(user);

    }


}


