package com.embedded.mot.operation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Operation implements Serializable {

    @Id
    private Long idOperation;
    private Long idModule;
    private String description;

    public Long getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(Long idOperation) {
        this.idOperation = idOperation;
    }

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
        Operation operation = (Operation) o;
        return Objects.equals(idOperation, operation.idOperation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOperation);
    }
}
