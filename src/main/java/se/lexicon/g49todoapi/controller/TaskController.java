package se.lexicon.g49todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.g49todoapi.domanin.dto.TaskDTOForm;
import se.lexicon.g49todoapi.domanin.dto.TaskDTOView;
import se.lexicon.g49todoapi.service.TaskService;

import java.util.List;

@RequestMapping("api/v1/tasks")
@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskDTOView> doCreate(@RequestBody TaskDTOForm dtoForm){
        TaskDTOView  responseBody = taskService.create(dtoForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTOView>> findAll() {
        return null;
    }
    @GetMapping
    public List<TaskDTOView> getTasks() {
        return null;
    }
}
