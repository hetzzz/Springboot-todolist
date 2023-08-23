package com.het.todolist.Controller;


import com.het.todolist.Entity.User;
import com.het.todolist.Exceptions.UserAlreadyExistsException;
import com.het.todolist.Filters.UserGetMappingFilter;
import com.het.todolist.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserGetMappingFilter userGetFilter;

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) throws UserAlreadyExistsException {

        if(userRepository.findByUserName(user.getUserName()) != null){
            throw new UserAlreadyExistsException("userName : "+user.getUserName()+ " already Exists");
        }

        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userName}").buildAndExpand(savedUser.getUserName()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/user/{userName}")
    public void deleteUser(@PathVariable String userName){
        userRepository.deleteById(userName);
    }

    @GetMapping("/user")
    public MappingJacksonValue getAllUsers(){
        return userGetFilter.filter(userRepository.findAll());
    }

    @GetMapping("/user/{userName}")
    public MappingJacksonValue getAllUsers(@PathVariable String userName){
        return userGetFilter.filter(userRepository.findByUserName(userName));
    }



}
