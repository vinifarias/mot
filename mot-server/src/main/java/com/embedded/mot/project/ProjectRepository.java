package com.embedded.mot.project;

import com.embedded.mot.project.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "https://mot-client-web.herokuapp.com")
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Query(value = "SELECT * FROM project ORDER BY id_project DESC LIMIT 1",
            nativeQuery = true)
    Long getGreatestId();
}
