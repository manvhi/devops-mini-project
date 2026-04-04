package com.example.devopsdemo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class TaskController {

    private List<String> tasks = new ArrayList<>();

    @GetMapping("/tasks")
    public List<String> getTasks() {
        return tasks;
    }

    @PostMapping("/tasks")
    public String addTask(@RequestBody String task) {
        tasks.add(task);
        return "Task added";
    }

    @DeleteMapping("/tasks/{index}")
    public String deleteTask(@PathVariable int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            return "Task deleted";
        }
        return "Invalid index";
    }
}// demo comment
