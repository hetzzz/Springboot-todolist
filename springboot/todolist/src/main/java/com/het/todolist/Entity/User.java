package com.het.todolist.Entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;


@Entity
@JsonFilter("userGetMappingFilter")
public class User {


    @Id
    @Size(min = 1 ,message="Username cannot be blank")
    private String userName;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$",message = "length must be atleast 8")
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Tasks> task;

    public User(){

    }
    public User(String userName, String password, List<Tasks> task) {
        this.userName = userName;
        this.password = password;
        this.task = task;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Tasks> getTask() {
        return task;
    }

    public void setTask(List<Tasks> task) {
        this.task = task;
    }

}
