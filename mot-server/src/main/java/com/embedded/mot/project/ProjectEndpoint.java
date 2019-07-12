package com.embedded.mot.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("projects")
@CrossOrigin(origins = "*")
public class ProjectEndpoint {

    private final ProjectService projectService;

    @Autowired
    public ProjectEndpoint(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(projectService.findAll(), HttpStatus.OK);
    }
}
