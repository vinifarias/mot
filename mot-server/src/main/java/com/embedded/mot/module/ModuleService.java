package com.embedded.mot.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;


@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    public List<Module> findAll() {

        Iterable<Module> modules = moduleRepository.findAll();
        List<Module> modulesResult = new ArrayList<>();

        for(Module module : modules) {
            modulesResult.add(module);
        }

        return modulesResult;
    }

    public Module findById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Module id is null!");
        }
        if(!moduleRepository.existsById(id)) {
            throw new RuntimeException("Module not found!");
        }

        return moduleRepository.findById(id).get();
    }

    public List<Module> findByDescription(String description) {

        if(isNull(description)) {
            throw new NullPointerException("Module id is null!");
        }

        return moduleRepository.findByDescription(description);
    }


    public Module save(Module module) {

        module.setIdModule(this.getNewId());

        if(isNull(module)) {
            throw new NullPointerException("Module is null!");
        }

        return moduleRepository.save(module);
    }

    public void deleteById(Long id) {

        if(isNull(id)) {
            throw new NullPointerException("Module id is null!");
        }
        if(!moduleRepository.existsById(id)) {
            throw new RuntimeException("Module not found!");
        }

        moduleRepository.deleteById(id);
    }

    public Long getNewId() {
        Long newId = moduleRepository.getGreatestId() + 1;
        return newId;
    }
}
