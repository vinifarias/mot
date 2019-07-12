package com.embedded.mot.projectTask;

import com.embedded.mot.projectTask.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://mot-client-web.herokuapp.com")
public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long> {

    @Query(value = "SELECT project_task_model.*, project_model.description project_description" +
                    " FROM project_task project_task_model, task task_model, project project_model" +
                    " WHERE task_model.description = :description and task_model.id_task = project_task_model.id_task and project_model.id_project = project_task_model.id_project" +
                    " ORDER BY project_model.description",
            nativeQuery = true)
    List<Map> findProjectTasksByTaskDescription(@Param("description") String description);

    @Query(value = "SELECT AVG(project_task_model.planned_hours) avg_planned_hours, AVG(project_task_model.worked_hours) avg_worked_hours" +
                    " FROM project_task project_task_model, task task_model" +
                    " WHERE task_model.description = :description AND task_model.id_task = project_task_model.id_task",
            nativeQuery = true)
    Map getAverageHoursByDescription(@Param("description") String description);

    @Query(value = "SELECT hours FROM task_hours WHERE id_task = :taskId",
            nativeQuery = true)
    Double getPredictedHoursByTaskId(@Param("taskId") int taskId);
}
