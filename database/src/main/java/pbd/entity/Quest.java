package pbd.entity;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;

@Entity
public class Quest {
    @PrimaryKey
    private String title;

    private String description;

    private Player performer;

    private NPC principal;

}
