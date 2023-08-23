package com.het.todolist.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaskNotFoundException extends Throwable {
    public TaskNotFoundException(String s) {
        super(s);
    }
}
