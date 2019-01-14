package pbd.entity;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import java.util.List;

@PersistenceCapable
public class Team {
    public Team(String teamName, List<Character> characters) {
        this.teamName = teamName;
        this.characters = characters;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", characters=" + characters +
                '}';
    }

    @PrimaryKey
    private String teamName;

    @Column(allowsNull = "false")
    private List<Character> characters;
}
