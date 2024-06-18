package se.lexicon.g49todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.g49todoapi.domanin.dto.TaskDTOForm;
import se.lexicon.g49todoapi.domanin.dto.TaskDTOView;
import se.lexicon.g49todoapi.service.TaskService;



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

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTOView> doFindTaskById(@PathVariable Long id) {
        System.out.println(">>>>>>> get Task by Id has been executed");
        System.out.println("Id: " + id);

        TaskDTOView responseBody = taskService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> doUpdate(@RequestBody TaskDTOForm dtoForm) {
        System.out.println(">>>>>>> Updated Task By DTO form has been executed");
        taskService.update(dtoForm);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<Void> doDelete(@PathVariable Long id) {
        System.out.println(">>>>>>> Deleted Task By Id has been executed");
        taskService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
