package Game;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GameScoreTracker
{
    static Map<String,Integer> playerScore = new HashMap<>();
    //player name and score
    public void addPlayer(String pName)
    {
         playerScore.put(pName,1);
    }


    public void RecordScore(String playerName, int score) {

        playerScore.put(playerName, playerScore.get(playerName) + score);
    }

    public int highestScore()
    {
        return  playerScore.values().stream().max(Integer::compare).orElse(0);
    }

    public Map<String, Integer> getWinners()
    {
        int highestScore = highestScore();
        System.out.println(highestScore);

        HashMap<String, Integer> winners = new HashMap<>();

        for (Map.Entry<String, Integer> entry : playerScore.entrySet()) {
            if (entry.getValue() == highestScore) {
                winners.put(entry.getKey(), entry.getValue());
            }
        }
        if(winners.size()>1)
        {
            System.out.println("Draw");
            return winners;
        }
        return winners;
    }

    public int PlayerScore(String name)
    {
        return playerScore.getOrDefault(name, 0);
    }
}
