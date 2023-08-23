package com.het.todolist.Repository;


import com.het.todolist.Entity.Tasks;
import com.het.todolist.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Tasks,Integer> {
    Tasks findByid(Integer id);
    List<Tasks> findByUser(User user);
//    Tasks findByUserAndid(User user,Integer id);
    List<Tasks> findByUserUserName(String userName);
    Tasks findByIdAndUserUserName(Integer id,String userName);
    void deleteByIdAndUserUserName(Integer id, String userName);
}
