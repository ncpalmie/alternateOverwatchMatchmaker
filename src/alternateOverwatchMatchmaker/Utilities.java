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
	
	public static double[] parseForStatsById(int heroId, String textToParse) {
		String[] timeStrings;
		double seconds = 0;
		double[] retArray = new double[5];
		String[] lineArray = textToParse.split("\n");
		
		//Elims
		retArray[0] = Double.valueOf(lineArray[(heroId * 8) + 2]);
		
		//Objective Kills
		retArray[1] = Double.valueOf(lineArray[(heroId * 8) + 3]);
		
		//Objective Time (in seconds)
		timeStrings = lineArray[(heroId * 8) + 4].split(":");
		seconds += Double.valueOf(timeStrings[0]) * 60;
		seconds += Double.valueOf(timeStrings[1]);
		retArray[2] = seconds;
		
		//Damage
		retArray[3] = Double.valueOf(lineArray[(heroId * 8) + 5].replace(",", ""));

		
		
		
		return retArray;
	}
}
