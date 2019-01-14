package pbd.entity;


import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.GeneratedValue;

@PersistenceCapable
public class Roll {
    @PrimaryKey
    @GeneratedValue
    private int id;

    private Round round;

    private int dice;

    private int diceAmount;

}
