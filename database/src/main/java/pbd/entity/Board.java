package pbd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Board {
    @Id
    @GeneratedValue
    private int id;

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
