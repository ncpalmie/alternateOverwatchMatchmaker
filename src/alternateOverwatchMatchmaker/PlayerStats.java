package alternateOverwatchMatchmaker;

public class PlayerStats extends Stats {

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
}
