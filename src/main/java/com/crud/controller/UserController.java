package com.crud.controller;

import com.crud.model.User;
import com.crud.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceI userServiceI;
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User saveUser = userServiceI.createUser(user);

        return new ResponseEntity<>(saveUser , HttpStatus.CREATED) ;//201
    }
    @GetMapping("/users")
     public ResponseEntity <List<User>> getAllUsers(){
        List<User> allUsers = userServiceI.getAllUsers();
        return new ResponseEntity<>(allUsers , HttpStatus.OK) ;
  }
  @GetMapping("/users/{userId}")
   public ResponseEntity <User> getUserById(@PathVariable Long userId) throws Exception{
      User user= userServiceI.getUserById(userId);
      return new ResponseEntity<>(user , HttpStatus.OK) ;
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user , @PathVariable Long userId){

        User updatedUser = userServiceI.updateUser(user, userId);
        return new ResponseEntity<>( updatedUser  , HttpStatus.CREATED) ;
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userServiceI.deleteUser(userId);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

}
