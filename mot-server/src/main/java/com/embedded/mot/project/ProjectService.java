package com.embedded.mot.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;


@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> findAll() {

        Iterable<Project> projects = projectRepository.findAll();
        List<Project> projectsResult = new ArrayList<>();

        for(Project project : projects) {
            projectsResult.add(project);
        }

        return projectsResult;
    }

    public Project findById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Project id is null!");
        }
        if(!projectRepository.existsById(id)) {
            throw new RuntimeException("Project not found!");
        }

        return projectRepository.findById(id).get();
    }

    public Long getNewId() {
        Long newId = projectRepository.getGreatestId() + 1;
        return newId;
    }
}
