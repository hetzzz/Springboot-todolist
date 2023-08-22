package com.het.todolist.Controller;


import com.het.todolist.Entity.Tasks;
import com.het.todolist.Exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.het.todolist.Repository.taskRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class taskController {


    @Autowired
    private taskRepository repository;


    @PostMapping("/task")
    public ResponseEntity<Tasks> addTask(@Valid @RequestBody Tasks task) {
        Tasks savedTask = repository.save(task);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedTask.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping("/task")
    public List<Tasks> getAllTask() {
        return repository.findAll();
    }

    @GetMapping("/task/{id}")
    public Tasks getTask(@PathVariable int id) {

        Tasks task = repository.findByid(id);
        if (task == null) {
            throw new UserNotFoundException("id" + id);
        }
        return task;
    }
    //todelete a particular Task
    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable int id){
        repository.deleteById(id);
    }


}