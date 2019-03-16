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
     * @param skill represents on a scale of 1-7 how skilled the random player should be. Randomly generated
     *                     characters with the same capabilities can still have different stats, just in a similar range
     * @return a Player with randomized stats within a range determined by the given skill value
     */
    public Player generateRandomPlayer(int skill) {
        Player retPlayer = new Player();
        retPlayer.setPingToServers(new int[] {randomGenerator.nextInt(200), randomGenerator.nextInt(200),
                randomGenerator.nextInt(200), randomGenerator.nextInt(200), randomGenerator.nextInt(200)});
        retPlayer.setTopThreeHeroes(new Hero[] {Hero.getHeroList().get(randomGenerator.nextInt(26)), Hero.getHeroList().get(
                randomGenerator.nextInt(26)), Hero.getHeroList().get(randomGenerator.nextInt(26))});
        retPlayer.setRollQueueOrder(new String[] {Hero.heroTypes[randomGenerator.nextInt(3)], Hero.heroTypes[
                randomGenerator.nextInt(3)], Hero.heroTypes[randomGenerator.nextInt(3)]});
        retPlayer.setWillingnessToChange(randomGenerator.nextDouble() % 1.0);
        retPlayer.setPlayerStats(PlayerStats.generateRandomStats(skill));
        return retPlayer;
    }

    public double getWillingnessToChange() {
        return willingnessToChange;
    }

    public void setWillingnessToChange(double willingnessToChange) {
        this.willingnessToChange = willingnessToChange;
    }

    public Hero[] getTopThreeHeroes() {
        return topThreeHeroes;
    }

    public void setTopThreeHeroes(Hero[] topThreeHeroes) {
        this.topThreeHeroes = topThreeHeroes;
    }

    public int[] getPingToServers() {
        return pingToServers;
    }

    public void setPingToServers(int[] pingToServers) {
        this.pingToServers = pingToServers;
    }

    public PlayerStats getPlayerStats() {
        return this.playerStats;
    }

    public void setPlayerStats(PlayerStats playerStats) {
        this.playerStats = playerStats;
    }

    public String[] getRollQueueOrder() {
        return rollQueueOrder;
    }

    public void setRollQueueOrder(String[] rollQueueOrder) {
        this.rollQueueOrder = rollQueueOrder;
    }
}
