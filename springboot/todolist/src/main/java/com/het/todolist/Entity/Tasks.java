package com.het.todolist.Entity;


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
    @Size(min = 1 , message = "Task cannot be blank")
    private String tasks;
    @FutureOrPresent
    private LocalDate date;
    @Column(columnDefinition = "boolean default false")
    private boolean status;

    public Tasks(){

    }

    public Tasks(Integer id, String tasks, LocalDate date, boolean status) {
        this.id = id;
        this.tasks = tasks;
        this.date = date;
        this.status = status;
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
