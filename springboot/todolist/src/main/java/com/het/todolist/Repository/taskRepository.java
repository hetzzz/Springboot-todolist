package com.het.todolist.Repository;


import com.het.todolist.Entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface taskRepository extends JpaRepository<Tasks,Integer> {
    Tasks findByid(Integer id);
}
