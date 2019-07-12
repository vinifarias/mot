package com.embedded.mot.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class TaskHours implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTaskHours;
    private Long idTask;
    private Double hours;

    public Long getIdTaskHours() {
        return idTaskHours;
    }

    public Long getIdTask() {
        return idTask;
    }

    public Double getHours() {
        return hours;
    }

    public void setIdTaskHours(Long idTaskHours) {
        this.idTaskHours = idTaskHours;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskHours taskHours = (TaskHours) o;
        return Objects.equals(idTask, taskHours.idTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTask);
    }
}
