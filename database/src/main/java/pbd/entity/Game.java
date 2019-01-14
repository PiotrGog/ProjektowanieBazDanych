package pbd.entity;


import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable
public class Game {
    @PrimaryKey
    @GeneratedValue
    private int id;

    @Column(allowsNull = "false")
    private List<Player> players;

    @Column(allowsNull = "false")
    private List<Round> rounds;

    @Column(allowsNull = "false")
    private List<RoundSummary> gameHistory;

    @Column(allowsNull = "false")
    private List<NPC> npcs;

    public int getId() {
        return id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public List<RoundSummary> getGameHistory() {
        return gameHistory;
    }

    public Round getCurrentRound(){
        return rounds.get(rounds.size()-1);
    }

    public List<RoundSummary> getCharacterHistory(Character character){
        List<RoundSummary> characterHistory = new ArrayList<>();
        for(RoundSummary rs : gameHistory){
            if(rs.getPlayer().getName().equals(character.getName())){
                characterHistory.add(rs);
            }
        }
        return characterHistory;
    }
}
