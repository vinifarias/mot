package com.embedded.mot.projectTask;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ProjectTask implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idProject;
    private Long idTask;
    private String description;
    private double plannedHours;
    private double workedHours;
    private String responsible;
    private String experience;
    private String complexity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPlannedHours() {
        return plannedHours;
    }

    public void setPlannedHours(double plannedHours) {
        this.plannedHours = plannedHours;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectTask that = (ProjectTask) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
