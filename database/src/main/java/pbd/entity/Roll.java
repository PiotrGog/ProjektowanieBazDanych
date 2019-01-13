package pbd.entity;


import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Roll {
    @PrimaryKey
    @GeneratedValue
    private int id;

    private Round round;

    private int dice;

    private int diceAmount;

}
