package pbd.entity;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import java.util.List;

@PersistenceCapable
public class Field {
    //    @EmbeddedId
//    private FieldId id;
    int xCoordinate;
    int yCoordinate;


    @Column(allowsNull = "false")
    private List<Field> neighbourField;

    public Field(int xCoordinate, int yCoordinate, List<Field> neighbourField) {
//        this.id = new FieldId(xCoordinate, yCoordinate);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.neighbourField = neighbourField;
    }

    public List<Field> getNeighbourField() {
        return neighbourField;
    }

    public Field(List<Field> neighbourField) {

        this.neighbourField = neighbourField;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return xCoordinate;
    }
}

@PersistenceCapable(objectIdClass = Field.class)
class FieldId {
    @PrimaryKey
    int xCoordinate;
    @PrimaryKey
    int yCoordinate;

    FieldId(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
}