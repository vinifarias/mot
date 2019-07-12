package com.embedded.mot.task;

import com.embedded.mot.operation.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tasks")
@CrossOrigin(origins = "*")
public class TaskEndpoint {

    private final TaskService taskService;

    @Autowired
    public TaskEndpoint(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/findByDescription/{description}")
    public ResponseEntity<?> findByDescription(@PathVariable String description) {
        return new ResponseEntity<>(taskService.findByDescription(description), HttpStatus.OK);
    }

    @GetMapping(path = "/findByOperationDescription/{description}")
    public ResponseEntity<?> findOperationsByModuleDescription(@PathVariable String description) {
        return new ResponseEntity<>(taskService.findTasksByOperationDescription(description), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task save(@RequestBody Task task) {
        return taskService.save(task);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@RequestBody Long taskId) { taskService.deleteById(taskId); }
}
