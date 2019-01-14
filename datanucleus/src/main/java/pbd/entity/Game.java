package pbd.entity;


import javax.jdo.annotations.*;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable
public class Game {
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.NATIVE)
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

    /**
     * Returns rounds history of given character.
     * @param character object to list its history
     * @return list of RoundSummary objects which represtent history of given character
     */
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
