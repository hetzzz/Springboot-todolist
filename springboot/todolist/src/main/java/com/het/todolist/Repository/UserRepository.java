package com.het.todolist.Repository;

import com.het.todolist.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String userName);

}
