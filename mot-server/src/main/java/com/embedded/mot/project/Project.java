package com.embedded.mot.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Project implements Serializable {

    @Id
    private Long idProject;
    private String description;
    private String context;
    private int teamSize;

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(idProject, project.idProject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProject);
    }
}
