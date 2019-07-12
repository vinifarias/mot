package com.embedded.mot.task;

import com.embedded.mot.task.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "https://mot-client-web.herokuapp.com")
public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findByDescription(String description);

    @Query(value = "select task_model.*" +
            " from task task_model, operation operation_model" +
            " where operation_model.description = :description and task_model.id_operation = operation_model.id_operation" +
            " order by task_model.description asc",
            nativeQuery = true)
    List<Task> findTasksByOperationDescription(@Param("description") String description);

    @Query(value = "SELECT * FROM task ORDER BY id_task DESC LIMIT 1",
            nativeQuery = true)
    Long getGreatestId();
}