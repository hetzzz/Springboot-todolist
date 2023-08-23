package com.het.todolist.Controller;


import com.het.todolist.Entity.Tasks;
import com.het.todolist.Entity.User;
import com.het.todolist.Exceptions.UserNotFoundException;
import com.het.todolist.Repository.TaskRepository;
import com.het.todolist.Repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Transactional
public class TaskController {


    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/user/{userName}/task")
    public ResponseEntity<Tasks> addTask(@PathVariable String userName,@Valid @RequestBody Tasks task) {
        User user = userRepository.findByUserName(userName);
        if(user == null){
            throw new UserNotFoundException("userName : "+userName+ " doses not Exist");
        }
        task.setUser(user);
        Tasks savedTask = taskRepository.save(task);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedTask.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping("/user/{userName}/task")
    public List<Tasks> getAllTask(@PathVariable String userName) {
        System.out.println();
        return taskRepository.findByUserUserName(userName);
    }
//
    @GetMapping("/user/{userName}/task/{id}")
    public Tasks getTask(@Valid @PathVariable String userName,@PathVariable Integer id) {

        Tasks task = taskRepository.findByIdAndUserUserName(id,userName);
//        if (task == null) {
//            throw new UserNotFoundException("id" + id);
//        }
        System.out.println(task+" "+id);
        return task;
    }
    //todelete a particular Task
    @DeleteMapping("/user/{userName}/task/{id}")
    public void deleteTask(@PathVariable Integer id,@PathVariable String userName){
        taskRepository.deleteByIdAndUserUserName(id,userName);
    }


}