package com.embedded.mot.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;


@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    public List<Operation> findAll() {

        Iterable<Operation> operations = operationRepository.findAll();
        List<Operation> operationsResult = new ArrayList<>();

        for(Operation operation : operations) {
            operationsResult.add(operation);
        }

        return operationsResult;
    }

    public Operation findById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Operation id is null!");
        }
        if(!operationRepository.existsById(id)) {
            throw new RuntimeException("Operation not found!");
        }

        return operationRepository.findById(id).get();
    }

    public List<Operation> findByDescription(String description) {

        if(isNull(description)) {
            throw new NullPointerException("Operation id is null!");
        }

        return operationRepository.findByDescription(description);
    }

    public List<Operation> findOperationsByModuleDescription(String moduleDescription) {

        if(isNull(moduleDescription)) {
            throw new NullPointerException("Module Description id is null!");
        }

        return operationRepository.findOperationsByModuleDescription(moduleDescription);
    }


    public Operation save(Operation operation) {

        operation.setIdOperation(this.getNewId());

        if(isNull(operation)) {
            throw new NullPointerException("Operation is null!");
        }

        return operationRepository.save(operation);
    }

    public void deleteById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Operation id is null!");
        }
        if(!operationRepository.existsById(id)) {
            throw new RuntimeException("Operation not found!");
        }

        operationRepository.deleteById(id);
    }

    public Long getNewId() {
        Long newId = operationRepository.getGreatestId() + 1;
        return newId;
    }
}
