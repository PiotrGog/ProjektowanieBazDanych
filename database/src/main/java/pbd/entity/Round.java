package pbd.entity;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Round {

    @PrimaryKey
    @GeneratedValue
    private int roundNumber;

    public Round(int roundNumber) {
        this.roundNumber = roundNumber;
    }
}
