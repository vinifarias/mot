package com.embedded.mot.operation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "https://mot-client-web.herokuapp.com")
public interface OperationRepository extends CrudRepository<Operation, Long> {

    List<Operation> findByDescription(String description);

    @Query(value = "SELECT operation_model.*" +
                    " FROM operation operation_model, module module_model" +
                    " WHERE module_model.description = :description AND operation_model.id_module = module_model.id_module" +
                    " ORDER BY operation_model.description ASC",
            nativeQuery = true)
    List<Operation> findOperationsByModuleDescription(@Param("description") String description);


    @Query(value = "SELECT * FROM operation ORDER BY id_operation DESC LIMIT 1",
            nativeQuery = true)
    Long getGreatestId();
}
