package pbd.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RoundSummary {
    @Id
    @GeneratedValue
    private int id;

    private Round round;

    private Roll roll;

    private Player player;

    private int takenDamage;

    private int dealtDamage;

    private int health;

    private int level;

    public RoundSummary(Round round,
                        Roll roll,
                        Player player,
                        int takenDamage,
                        int dealtDamage,
                        int health,
                        int level) {
        this.round = round;
        this.roll = roll;
        this.player = player;
        this.takenDamage = takenDamage;
        this.dealtDamage = dealtDamage;
        this.health = health;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public Round getRound() {
        return round;
    }

    public Roll getRoll() {
        return roll;
    }

    public Player getPlayer() {
        return player;
    }

    public int getTakenDamage() {
        return takenDamage;
    }

    public int getDealtDamage() {
        return dealtDamage;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }
}
