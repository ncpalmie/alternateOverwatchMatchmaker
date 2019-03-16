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
     * @param skill value from 1-7 to determine range of stats generated, if skill falls outside this range the values
     *              will be completely random within the limits of possible values
     * @return
     */
    public static PlayerStats generateRandomStats(int skill) {
        PlayerStats retStats = new PlayerStats();
        switch(skill) {
            case 1:
                retStats.setEndorsementLevel(randomGenerator.nextInt(1) + 1);
                retStats.setCurrSeasonRanking(randomGenerator.nextInt(1500));
                retStats.setTotalWins(randomGenerator.nextInt(75));
                retStats.setNumEarlyLeaves((int) (randomGenerator.nextInt(4) *
                        Math.abs(randomGenerator.nextGaussian())));
                retStats.setTotalLosses(randomGenerator.nextInt(100));
                retStats.setCurrStreak(randomGenerator.nextInt(4));
                retStats.setEliminations((randomGenerator.nextDouble() % 12.0) + 6.0);
                retStats.setHealingDone(randomGenerator.nextInt(3000) + 5000);
                retStats.setHeroDamage(randomGenerator.nextInt(4000) + 5000);
                retStats.setObjectiveTime(randomGenerator.nextInt(45) + 80);
                retStats.setObjectiveElims(randomGenerator.nextDouble() % 7.0);
                break;
            case 2:
                retStats.setEndorsementLevel(randomGenerator.nextInt(1) + 1);
                retStats.setCurrSeasonRanking(randomGenerator.nextInt(700) + 1400);
                retStats.setTotalWins(randomGenerator.nextInt(100) + 10);
                retStats.setNumEarlyLeaves((int) (randomGenerator.nextInt(8) *
                        Math.abs(randomGenerator.nextGaussian())));
                retStats.setTotalLosses(randomGenerator.nextInt(80) + 10);
                retStats.setCurrStreak(randomGenerator.nextInt(5));
                retStats.setEliminations((randomGenerator.nextDouble() % 12.0) + 8.0);
                retStats.setHealingDone(randomGenerator.nextInt(3000) + 6200);
                retStats.setHeroDamage(randomGenerator.nextInt(4000) + 6000);
                retStats.setObjectiveTime(randomGenerator.nextInt(60) + 80);
                retStats.setObjectiveElims(randomGenerator.nextDouble() % 7.0);
                break;
            case 3:
                retStats.setEndorsementLevel(randomGenerator.nextInt(2) + 1);
                retStats.setCurrSeasonRanking(randomGenerator.nextInt(900) + 2200);
                retStats.setTotalWins(randomGenerator.nextInt(150) + 25);
                retStats.setNumEarlyLeaves((int) (randomGenerator.nextInt(10) *
                        Math.abs(randomGenerator.nextGaussian())));
                retStats.setTotalLosses(randomGenerator.nextInt(120) + 15);
                retStats.setCurrStreak(randomGenerator.nextInt(8));
                retStats.setEliminations((randomGenerator.nextDouble() % 12.0) + 10.0);
                retStats.setHealingDone(randomGenerator.nextInt(3000) + 7200);
                retStats.setHeroDamage(randomGenerator.nextInt(4000) + 7500);
                retStats.setObjectiveTime(randomGenerator.nextInt(60) + 80);
                retStats.setObjectiveElims(randomGenerator.nextDouble() % 8.0);
                break;
            case 4:
                retStats.setEndorsementLevel(randomGenerator.nextInt(2) + 1);
                retStats.setCurrSeasonRanking(randomGenerator.nextInt(1200) + 2800);
                retStats.setTotalWins(randomGenerator.nextInt(200) + 45);
                retStats.setNumEarlyLeaves((int) (randomGenerator.nextInt(15) *
                        Math.abs(randomGenerator.nextGaussian())));
                retStats.setTotalLosses(randomGenerator.nextInt(150) + 10);
                retStats.setCurrStreak(randomGenerator.nextInt(6));
                retStats.setEliminations((randomGenerator.nextDouble() % 16.0) + 12.0);
                retStats.setHealingDone(randomGenerator.nextInt(2700) + 8800);
                retStats.setHeroDamage(randomGenerator.nextInt(4000) + 10000);
                retStats.setObjectiveTime(randomGenerator.nextInt(70) + 90);
                retStats.setObjectiveElims(randomGenerator.nextDouble() % 9.0);
                break;
            case 5:
                retStats.setEndorsementLevel(randomGenerator.nextInt(3) + 1);
                retStats.setCurrSeasonRanking(randomGenerator.nextInt(900) + 3500);
                retStats.setTotalWins(randomGenerator.nextInt(250) + 80);
                retStats.setNumEarlyLeaves((int) (randomGenerator.nextInt(20) *
                        Math.abs(randomGenerator.nextGaussian())));
                retStats.setTotalLosses(randomGenerator.nextInt(260) + 70);
                retStats.setCurrStreak(randomGenerator.nextInt(7));
                retStats.setEliminations((randomGenerator.nextDouble() % 18.0) + 14.0);
                retStats.setHealingDone(randomGenerator.nextInt(1000) + 93000);
                retStats.setHeroDamage(randomGenerator.nextInt(5000) + 10000);
                retStats.setObjectiveTime(randomGenerator.nextInt(80) + 90);
                retStats.setObjectiveElims(randomGenerator.nextDouble() % 10.0);
                break;
            case 6:
                retStats.setEndorsementLevel(randomGenerator.nextInt(3) + 1);
                retStats.setCurrSeasonRanking(randomGenerator.nextInt(700) + 400);
                retStats.setTotalWins(randomGenerator.nextInt(500) + 100);
                retStats.setNumEarlyLeaves((int) (randomGenerator.nextInt(30) *
                        Math.abs(randomGenerator.nextGaussian())));
                retStats.setTotalLosses(randomGenerator.nextInt(500) + 90);
                retStats.setCurrStreak(randomGenerator.nextInt(7));
                retStats.setEliminations((randomGenerator.nextDouble() % 20.0) + 10.0);
                retStats.setHealingDone(randomGenerator.nextInt(1700) + 10000);
                retStats.setHeroDamage(randomGenerator.nextInt(5000) + 12000);
                retStats.setObjectiveTime(randomGenerator.nextInt(100) + 80);
                retStats.setObjectiveElims(randomGenerator.nextDouble() % 11.0);
                break;
            case 7:
                retStats.setEndorsementLevel(randomGenerator.nextInt(3) + 1);
                retStats.setCurrSeasonRanking(randomGenerator.nextInt(500) + 4500);
                retStats.setTotalWins(randomGenerator.nextInt(1300) + 120);
                retStats.setNumEarlyLeaves((int) (randomGenerator.nextInt(50) *
                        Math.abs(randomGenerator.nextGaussian())));
                retStats.setTotalLosses(randomGenerator.nextInt(1000) + 130);
                retStats.setCurrStreak(randomGenerator.nextInt(8));
                retStats.setEliminations((randomGenerator.nextDouble() % 22.0) + 10.0);
                retStats.setHealingDone(randomGenerator.nextInt(2000) + 10000);
                retStats.setHeroDamage(randomGenerator.nextInt(6000) + 12000);
                retStats.setObjectiveTime(randomGenerator.nextInt(100) + 90);
                retStats.setObjectiveElims(randomGenerator.nextDouble() % 13.0);
                break;
            default:
                retStats.setEndorsementLevel(randomGenerator.nextInt(4));
                retStats.setCurrSeasonRanking(randomGenerator.nextInt(5000));
                retStats.setTotalWins(randomGenerator.nextInt(2000));
                retStats.setNumEarlyLeaves((int) (randomGenerator.nextInt(100) *
                        Math.abs(randomGenerator.nextGaussian())));
                retStats.setTotalLosses(randomGenerator.nextInt(2000));
                retStats.setCurrStreak(randomGenerator.nextInt(10));
                retStats.setEliminations((randomGenerator.nextDouble() % 24.0));
                retStats.setHealingDone(randomGenerator.nextInt(12000));
                retStats.setHeroDamage(randomGenerator.nextInt(20000));
                retStats.setObjectiveTime(randomGenerator.nextInt(220));
                retStats.setObjectiveElims(randomGenerator.nextDouble() % 14.0);
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
