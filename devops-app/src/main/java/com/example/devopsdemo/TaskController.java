package com.example.devopsdemo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "*")
public class TaskController {

    private List<String> tasks = new ArrayList<>();

    // Returns all tasks
    @GetMapping("/tasks")
    public List<String> getTasks() {
        return tasks;
    }

    // Adds a new task
    @PostMapping("/tasks")
    public String addTask(@RequestBody String task) {
        tasks.add(task);
        return "Task added successfully";
    }

    // Deletes task by index
    @DeleteMapping("/tasks/{index}")
    public String deleteTask(@PathVariable int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            return "Task deleted successfully";
        }
        return "Invalid index";
    }
}