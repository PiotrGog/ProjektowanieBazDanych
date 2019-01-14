package pbd.entity;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Quest {
    @PrimaryKey
    private String title;

    @Column(allowsNull = "false")
    private String description;

    @Column(allowsNull = "false")
    private Player performer;

    @Column(allowsNull = "false")
    private NPC principal;

}
