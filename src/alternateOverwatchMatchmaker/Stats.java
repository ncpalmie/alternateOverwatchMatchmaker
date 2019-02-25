package alternateOverwatchMatchmaker;

public class Stats {
	private int objectiveElims;
	private int objectiveTime; //In seconds
	private int healingDone;
	private int heroDamage;
	private int eliminations;
	
	public Stats(int objectiveElims, int objectiveTime, int healingDone,
			int heroDamage, int eliminations) {
		this.objectiveElims = objectiveElims;
		this.objectiveTime = objectiveTime;
		this.healingDone = healingDone;
		this.heroDamage = heroDamage;
		this.eliminations = eliminations;
	}
}
