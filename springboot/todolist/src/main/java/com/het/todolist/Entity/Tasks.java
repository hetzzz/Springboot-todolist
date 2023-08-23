package com.het.todolist.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


@Entity
@Table
public class Tasks {

    @Id
    @GeneratedValue
    private Integer id;
//    @JsonProperty("task_name")
    @Size(min = 1 , message = "Task cannot be blank")
    private String tasks;
    @FutureOrPresent
    private LocalDate date;
    @Column(columnDefinition = "boolean default false")
    private boolean status;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Tasks(){

    }

    public Tasks(Integer id, String tasks, LocalDate date, boolean status, User user) {
        this.id = id;
        this.tasks = tasks;
        this.date = date;
        this.status = status;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getTasks() {
        return tasks;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", tasks='" + tasks + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
