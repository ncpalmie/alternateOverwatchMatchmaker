package alternateOverwatchMatchmaker;

public class Utilities {

	public Utilities() {
	}
	
	public static void sleepForXSeconds(double seconds) {
		try {
			Thread.sleep((long)seconds * 1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}
	
	public static float parseForPickRateById(int heroId, String textToParse) {
		String floatString;
		String[] lineArray = textToParse.split("\n");
		floatString = lineArray[(heroId * 6) + 2];
		return Float.valueOf(floatString.substring(0, floatString.length() - 1));
	}
	
	public static Stats parseForStatsById(int heroId, String textToParse) {
		String[] timeStrings;
		int seconds = 0;
		String[] lineArray = textToParse.split("\n");
		Stats retStats = new Stats();
		
		//Elims
		retStats.setEliminations(Double.valueOf(lineArray[(heroId * 7) + 2]));
		
		//Objective Kills
		retStats.setObjectiveElims(Double.valueOf(lineArray[(heroId * 7) + 3]));
		
		//Objective Time (in seconds)
		timeStrings = lineArray[(heroId * 7) + 4].split(":");
		seconds += Integer.valueOf(timeStrings[0]) * 60;
		seconds += Integer.valueOf(timeStrings[1]);
		retStats.setObjectiveTime(seconds);
		
		//Damage
		retStats.setHeroDamage(Integer.valueOf(lineArray[(heroId * 7) + 5].replace(",", "")));

		//Healing
		retStats.setHealingDone(Integer.valueOf(lineArray[(heroId * 7) + 6].replace(",", "")));

		return retStats;
	}
}
