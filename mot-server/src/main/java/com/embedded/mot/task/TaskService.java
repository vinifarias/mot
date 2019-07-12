package com.embedded.mot.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {

        Iterable<Task> tasks = taskRepository.findAll();
        List<Task> tasksResult = new ArrayList<>();

        for(Task task : tasks) {
            tasksResult.add(task);
        }

        return tasksResult;
    }

    public Task findById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Task id is null!");
        }
        if(!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found!");
        }

        return taskRepository.findById(id).get();
    }

    public List<Task> findByDescription(String description) {

        if(isNull(description)) {
            throw new NullPointerException("Description is null!");
        }

        return taskRepository.findByDescription(description);
    }

    public List<Task> findTasksByOperationDescription(String operationDescription) {

        if(isNull(operationDescription)) {
            throw new NullPointerException("Operation description is null!");
        }

        return taskRepository.findTasksByOperationDescription(operationDescription);
    }


    public Task save(Task task) {

        task.setIdTask(this.getNewId());

        if(isNull(task)) {
            throw new NullPointerException("Task is null!");
        }

        return taskRepository.save(task);
    }

    public void deleteById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Task id is null!");
        }
        if(!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found!");
        }

        taskRepository.deleteById(id);
    }

    public Long getNewId() {
        Long newId = taskRepository.getGreatestId() + 1;
        return newId;
    }
}
