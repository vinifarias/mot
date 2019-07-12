package com.embedded.mot.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("operations")
@CrossOrigin(origins = "*")
public class OperationEndpoint {

    private final OperationService operationService;

    @Autowired
    public OperationEndpoint(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(operationService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/findByDescription/{description}")
    public ResponseEntity<?> findByDescription(@PathVariable String description) {
        return new ResponseEntity<>(operationService.findByDescription(description), HttpStatus.OK);
    }

    @GetMapping(path = "/findByModuleDescription/{description}")
    public ResponseEntity<?> findOperationsByModuleDescription(@PathVariable String description) {
        return new ResponseEntity<>(operationService.findOperationsByModuleDescription(description), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Operation save(@RequestBody Operation operation) {
        return operationService.save(operation);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@RequestBody Long operationId) { operationService.deleteById(operationId); }
}
