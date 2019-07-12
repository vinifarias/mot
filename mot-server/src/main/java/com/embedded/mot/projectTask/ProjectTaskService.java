package com.embedded.mot.projectTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;


@Service
public class ProjectTaskService {

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public List<ProjectTask> findAll() {

        Iterable<ProjectTask> projectTasks = projectTaskRepository.findAll();
        List<ProjectTask> projectTasksResult = new ArrayList<>();

        for(ProjectTask projectTask : projectTasks) {
            projectTasksResult.add(projectTask);
        }

        return projectTasksResult;
    }

    public ProjectTask findById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("ProjectTask id is null!");
        }
        if(!projectTaskRepository.existsById(id)) {
            throw new RuntimeException("ProjectTask not found!");
        }

        return projectTaskRepository.findById(id).get();
    }

    public List<Map> findProjectTasksByTaskDescription(String taskDescription) {

        if(isNull(taskDescription)) {
            throw new NullPointerException("Task description is null!");
        }

        return projectTaskRepository.findProjectTasksByTaskDescription(taskDescription);
    }

    public Map getAverageHoursByDescription(String taskDescription) {

        if(isNull(taskDescription)) {
            throw new NullPointerException("Task description is null!");
        }

        return projectTaskRepository.getAverageHoursByDescription(taskDescription);
    }

    public Double getPredictedHoursByTaskId(int taskId) {

        if(isNull(taskId)) {
            throw new NullPointerException("Task id is null!");
        }

        return projectTaskRepository.getPredictedHoursByTaskId(taskId);
    }

    public ProjectTask save(ProjectTask projectTask) {

        if(isNull(projectTask)) {
            throw new NullPointerException("ProjectTask is null!");
        }

        return projectTaskRepository.save(projectTask);
    }

    public void deleteById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("ProjectTask id is null!");
        }
        if(!projectTaskRepository.existsById(id)) {
            throw new RuntimeException("ProjectTask not found!");
        }

        projectTaskRepository.deleteById(id);
    }
}
