package com.embedded.mot.projectTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("projectTasks")
@CrossOrigin(origins = "*")
public class ProjectTaskEndpoint {

    private final ProjectTaskService projectTaskService;

    @Autowired
    public ProjectTaskEndpoint(ProjectTaskService projectTaskService) {
        this.projectTaskService = projectTaskService;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(projectTaskService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/findProjectTasksByTaskDescription/{description}")
    public ResponseEntity<?> findProjectTasksByTaskDescription(@PathVariable String description) {
        return new ResponseEntity<>(projectTaskService.findProjectTasksByTaskDescription(description), HttpStatus.OK);
    }

    @GetMapping(path = "/getAverageHoursByDescription/{description}")
    public ResponseEntity<?> getAverageHoursByDescription(@PathVariable String description) {
        return new ResponseEntity<>(projectTaskService.getAverageHoursByDescription(description), HttpStatus.OK);
    }

    @GetMapping(path = "/getPredictedHoursByTaskId/{IdTask}")
    public ResponseEntity<?> getAverageHoursByDescription(@PathVariable int IdTask) {
        return new ResponseEntity<>(projectTaskService.getPredictedHoursByTaskId(IdTask), HttpStatus.OK);
    }
}
