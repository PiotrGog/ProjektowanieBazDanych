package pbd.entity;


import javax.jdo.annotations.*;

@PersistenceCapable
public class RoundSummary {
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.NATIVE)
    private int id;

    @Column(allowsNull = "false")
    private Round round;

    @Column(allowsNull = "false")
    private Roll roll;

    @Column(allowsNull = "false")
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
