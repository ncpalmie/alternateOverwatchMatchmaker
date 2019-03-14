package alternateOverwatchMatchmaker;

import java.util.Random;

public class PlayerStats extends Stats {

    private static Random randomGenerator = new Random();
    private float winRate;
    private int endorsementLevel;
    private int totalWins;
    private int totalLosses;
    private int currSeasonRanking;
    private int numEarlyLeaves;
    private int currStreak; //Negative value implies number of losses in a row, positive implies number of wins in a row

    public PlayerStats(double objElims, int objTime, int healingDone, int heroDamage, double elims, float winRate,
                       int endorseLvl, int totalWins, int totalLoss, int currSR, int numLeaves, int currStreak) {
        super(objElims, objTime, healingDone, heroDamage, elims);
        this.winRate = winRate;
        this.endorsementLevel = endorseLvl;
        this.totalWins = totalWins;
        this.totalLosses = totalLoss;
        this.currSeasonRanking = currSR;
        this.numEarlyLeaves = numLeaves;
        this.currStreak = currStreak;
    }

    public PlayerStats() {
        super();
        this.winRate = 0f;
        this.endorsementLevel = 0;
        this.totalLosses = 0;
        this.totalWins = 0;
        this.currSeasonRanking = 0;
        this.numEarlyLeaves = 0;
        this.currStreak = 0;
    }

    /**
     * Generates a set of player skill values randomly
     * @param skill value from 1-100 to determine range of stats generated
     * @return
     */
    public static PlayerStats generateRandomStats(int skill) {
        PlayerStats retStats = new PlayerStats();
        if (skill < 15) {
            retStats.setEndorsementLevel(randomGenerator.nextInt(1) + 1);
            retStats.setCurrSeasonRanking(randomGenerator.nextInt(1500));
            retStats.setTotalWins(randomGenerator.nextInt(25));
            retStats.setNumEarlyLeaves((int) (randomGenerator.nextInt(4) * Math.abs(randomGenerator.nextGaussian())));
            retStats.setTotalLosses(randomGenerator.nextInt(40));
            retStats.setCurrStreak(randomGenerator.nextInt(4));
            retStats.setEliminations((randomGenerator.nextDouble() % 12.0) + 6.0);
            retStats.setHealingDone(randomGenerator.nextInt(3000) + 5000);
            retStats.setHeroDamage(randomGenerator.nextInt(4000) + 5000);
            retStats.setObjectiveTime(randomGenerator.nextInt(45) + 80);
            retStats.setObjectiveElims(randomGenerator.nextDouble() % 11.0);
        }
        return retStats;
    }

    public void setWinRate(float winRate) {
        this.winRate = winRate;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public void setTotalLosses(int totalLosses) {
        this.totalLosses = totalLosses;
    }

    public void setNumEarlyLeaves(int numEarlyLeaves) {
        this.numEarlyLeaves = numEarlyLeaves;
    }

    public void setEndorsementLevel(int endorsementLevel) {
        this.endorsementLevel = endorsementLevel;
    }

    public void setCurrStreak(int currStreak) {
        this.currStreak = currStreak;
    }

    public void setCurrSeasonRanking(int currSeasonRanking) {
        this.currSeasonRanking = currSeasonRanking;
    }

    public int getCurrSeasonRanking() {
        return currSeasonRanking;
    }

    public int getEndorsementLevel() {
        return endorsementLevel;
    }

    public int getCurrStreak() {
        return currStreak;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public int getNumEarlyLeaves() {
        return numEarlyLeaves;
    }

    public int getTotalLosses() {
        return totalLosses;
    }

    public float getWinRate() { return winRate; }
}
