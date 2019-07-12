package com.embedded.mot.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Module implements Serializable {

    @Id
    private Long idModule;
    private String description;

    public Long getIdModule() {
        return idModule;
    }

    public void setIdModule(Long idModule) {
        this.idModule = idModule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return Objects.equals(idModule, module.idModule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idModule);
    }
}
