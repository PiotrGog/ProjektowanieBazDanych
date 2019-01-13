package pbd.entity;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import java.util.List;

@Entity
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

    private List<Character> characters;
}
