package pbd.entity;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;

@Entity
public class Action {
    @PrimaryKey
    private String name;

    private String description;

    public Action(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
