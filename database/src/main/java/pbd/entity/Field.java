package pbd.entity;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class Field {
    @EmbeddedId
    private FieldId id;

    private List<Field> neighbourField;

    public Field(int xCoordinate, int yCoordinate, List<Field> neighbourField) {
        this.id = new FieldId(xCoordinate, yCoordinate);
        this.neighbourField = neighbourField;
    }

    public List<Field> getNeighbourField() {
        return neighbourField;
    }

    public Field(List<Field> neighbourField) {

        this.neighbourField = neighbourField;
    }

    public int getXCoordinate()
    {
        return id.xCoordinate;
    }

    public int getYCoordinate()
    {
        return id.xCoordinate;
    }
}

@Embeddable
class FieldId{
    int xCoordinate;
    int yCoordinate;

    public FieldId(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
}