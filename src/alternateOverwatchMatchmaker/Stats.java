package alternateOverwatchMatchmaker;

public class Stats {
	private double objectiveElims;
	private int objectiveTime; //In seconds
	private int healingDone;
	private int heroDamage;
	private double eliminations;
	
	public Stats(double objectiveElims, int objectiveTime, int healingDone,
				 int heroDamage, double eliminations) {
		this.objectiveElims = objectiveElims;
		this.objectiveTime = objectiveTime;
		this.healingDone = healingDone;
		this.heroDamage = heroDamage;
		this.eliminations = eliminations;
	}

	public Stats() {
		this.objectiveElims = 0;
		this.objectiveTime = 0;
		this.healingDone = 0;
		this.heroDamage = 0;
		this.eliminations = 0;
	}

	public void setObjectiveElims(double objElims) {
		this.objectiveElims = objElims;
	}

	public void setObjectiveTime(int objTime) {
		this.objectiveTime = objTime;
	}

	public void setHealingDone(int healingDone) {
		this.healingDone = healingDone;
	}

	public void setHeroDamage(int heroDamage) {
		this.heroDamage = heroDamage;
	}

	public void setEliminations(double elims) {
		this.eliminations = elims;
	}

	public double getEliminations() {
		return eliminations;
	}

	public double getObjectiveElims() {
		return objectiveElims;
	}

	public int getHealingDone() {
		return healingDone;
	}

	public int getHeroDamage() {
		return heroDamage;
	}

	public int getObjectiveTime() {
		return objectiveTime;
	}

	@Override

	public String toString() {
		String retString = "";

		retString += "Elims: " + this.eliminations;
		retString += " | ObjElims: " + this.objectiveElims;
		retString += " | ObjTime: " + this.objectiveTime;
		retString += " | Damage: " + this.heroDamage;
		retString += " | Healing: " + this.healingDone;

		return retString;
	}
}
