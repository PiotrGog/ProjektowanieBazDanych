package pbd.entity;

import javax.jdo.annotations.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@PersistenceCapable
public class Board {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
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

    public static Board boardFactory() {
        ArrayList<ArrayList<Field>> f = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            f.add(new ArrayList<>(50));
            for (int j = 0; j < 50; j++) {
                if (rand.nextBoolean()) {
                    f.get(i).add(new Field(i, j, new ArrayList<>()));
                }
            }
        }
        ArrayList<Field> fild = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (null != f.get(i).get(j)) {
                    for (int x = -1; x < 2; x++) {
                        for (int y = -1; y < 2; y++) {
                            if (x != 0 && y != 0 && i + x >= 0 && i + x < 50 && j + y >= 0 && j + y < 50 &&
                                    null != f.get(i + x).get(j + y)) {
                                f.get(i).get(j).getNeighbourField().add(f.get(i + x).get(j + y));
                            }
                        }
                    }
                    fild.add(f.get(i).get(j));
                }
            }
        }
        return new Board(fild);
    }
}
