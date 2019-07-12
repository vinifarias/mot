package com.embedded.mot.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("modules")
@CrossOrigin(origins = "*")
public class ModuleEndpoint {

    private final ModuleService moduleService;

    @Autowired
    public ModuleEndpoint(ModuleService moduleService) { this.moduleService = moduleService; }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(moduleService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/findByDescription/{description}")
    public ResponseEntity<?> findModuleByDescription(@PathVariable String description) {
        return new ResponseEntity<>(moduleService.findByDescription(description), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Module save(@RequestBody Module module) {
        return moduleService.save(module);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@RequestBody Long moduleId) { moduleService.deleteById(moduleId); }
}
