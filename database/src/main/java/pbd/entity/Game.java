package pbd.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {
    @Id
    private int id;

    private List<Player> players;

    private List<Round> rounds;

    private List<RoundSummary> gameHistory;

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
