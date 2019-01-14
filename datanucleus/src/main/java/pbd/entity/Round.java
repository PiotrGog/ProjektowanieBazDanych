package pbd.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Round {

    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.NATIVE)
    private int roundNumber;

    public Round(int roundNumber) {
        this.roundNumber = roundNumber;
    }
}
