package pbd.entity;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@PersistenceCapable
public class Board {
    @PrimaryKey
    @GeneratedValue
    private int id;

    @Column(allowsNull = "false")
    private List<Field> fields;

    public Board(List<Field> fields) {
        this.fields = fields;
    }

    public int getId() {
        return id;
    }

    public List<Field> getFields() {
        return fields;
    }
}
