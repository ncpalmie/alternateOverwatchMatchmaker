package alternateOverwatchMatchmaker;

import java.util.List;
import java.util.Random;

public class Player {

    private PlayerStats playerStats;
    private Hero[] topThreeHeroes;
    private String[] rollQueueOrder;
    private double willingnessToChange;
    private int[] pingToServers;
    private static Random randomGenerator;

    public Player (PlayerStats playerStats, Hero[] topThreeHeroes, String[] rollQueueOrder, double wtc) {
        this.playerStats = playerStats;
        this.topThreeHeroes = topThreeHeroes;
        this.rollQueueOrder = rollQueueOrder;
        this.willingnessToChange = wtc;
    }

    public Player() {
        this.playerStats = PlayerStats.generateRandomStats(0);
        this.topThreeHeroes = null;
        this.rollQueueOrder = null;
        this.willingnessToChange = 0;
        this.pingToServers = null;
    };

    /**
     *
     * @param skill represents on a scale of 1-100 how skilled the random player should be. Randomly generated
     *                     characters with the same capabilities can still have different stats, just in a similar range
     * @return a Player with randomized stats within a range determined by the given skill value
     */
    public Player generateRandomPlayer(int skill) {
        Player retPlayer = new Player();
        return retPlayer;
    }
}
