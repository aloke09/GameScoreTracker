import Game.GameScoreTracker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameScoreTrackerTest
{
    static GameScoreTracker gt;
    @BeforeAll
    public static void setup()
    {
        gt = new GameScoreTracker();
    }


    @Test
    public void testAddPlayer() {
        String p="Player1";
        gt.addPlayer(p);
        assertEquals(1, gt.PlayerScore(p));
    }
    @Test
    public void testAddPlayer2() {
        String p="Player1";
        gt.addPlayer(p);
        gt.RecordScore(p,5);
        assertEquals(6, gt.PlayerScore(p));
    }

    @Test//2 winner
    public void testAddPlayersAndDetermineWinner() {
        String p1 = "Player1";
        gt.addPlayer(p1);
        gt.RecordScore(p1, 15);

        String p2 = "Player2";
        gt.addPlayer(p2);
        gt.RecordScore(p2, 15);

        HashMap<String, Integer> win = (HashMap<String, Integer>) gt.getWinners();
        assertEquals(2, win.size());


    }

    @Test//single winner
    public void testAddPlayersAndDetermineWinner2() {
        String p1 = "Player1";
        gt.addPlayer(p1);
        gt.RecordScore(p1, 10);

        String p2 = "Player2";
        gt.addPlayer(p2);
        gt.RecordScore(p2, 15);

        Map<String, Integer> win = gt.getWinners();
        System.out.println(win);
        assertEquals(16, Integer.parseInt(String.valueOf(win.get(p2))));

    }
    @ParameterizedTest
    @ValueSource(ints = {10, 20, 30})
    public void testRecordScoreWithDifferentValues(int score) {
        gt.addPlayer("Player1");
        gt.RecordScore("Player1", score);
        assertEquals(score+1, gt.PlayerScore("Player1"));
    }


}
