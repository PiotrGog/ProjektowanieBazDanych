package pbd.entity;

import javax.jdo.annotations.*;
import java.util.List;

@PersistenceCapable
public class Board {
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.NATIVE)
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
