package com.embedded.mot.module;

import com.embedded.mot.module.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "https://mot-client-web.herokuapp.com")
public interface ModuleRepository extends CrudRepository<Module, Long> {

    List<Module> findByDescription(String description);

    @Query(value = "SELECT * FROM module ORDER BY id_module DESC LIMIT 1",
            nativeQuery = true)
    Long getGreatestId();
}
