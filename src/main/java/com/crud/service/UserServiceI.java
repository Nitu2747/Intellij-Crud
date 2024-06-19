package com.crud.service;



import com.crud.model.User;

import java.util.List;

    public interface UserServiceI {

        //create

        User createUser(User user);


        //updateUser
        User updateUser(User user,Long userId);


        //get single data
        User getUserById(Long userId);


        //get all record

        List<User> getAllUsers();

        //delete user

        void deleteUser(Long userId);



    }


