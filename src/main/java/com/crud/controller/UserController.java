package com.crud.controller;

import com.crud.model.User;
import com.crud.service.UserServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserServiceI userServiceI;
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        logger.info("Entering the request to create data");
        User saveUser = userServiceI.createUser(user);
        logger.info("Completed the request to create data");
        return new ResponseEntity<>(saveUser , HttpStatus.CREATED) ;//201
    }
    @GetMapping("/users")
     public ResponseEntity <List<User>> getAllUsers(){
        List<User> allUsers = userServiceI.getAllUsers();
        return new ResponseEntity<>(allUsers , HttpStatus.OK) ;
  }
  @GetMapping("/users/{userId}")
   public ResponseEntity <User> getUserById(@PathVariable Long userId) throws Exception{
       logger.info("Entering the request for get the user with this UserId{} ",userId);
      User user= userServiceI.getUserById(userId);
      logger.info("Completed the request for get the user with this UserId{} ",userId);
      return new ResponseEntity<>(user , HttpStatus.OK) ;
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user , @PathVariable Long userId){
        logger.info("Entering the request for Update the user with this UserId{} ",userId);
        User updatedUser = userServiceI.updateUser(user, userId);
        logger.info("Completing the request for Update the user with this UserId{} ",userId);
        return new ResponseEntity<>( updatedUser  , HttpStatus.CREATED) ;
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userServiceI.deleteUser(userId);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

}
