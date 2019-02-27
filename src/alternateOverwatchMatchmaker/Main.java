package alternateOverwatchMatchmaker;

import java.util.List;

public class Main {
	
	public static boolean debug = true;

	public static void main(String[] args){
		WebScraper.setupPage();
		
		List<Hero> heroes = Hero.getHeroList();
		System.out.println(heroes.get(12).toString());
		
		while(!WebScraper.closeDriver()) {
			System.out.println("Failed to close driver, trying again...");
			Utilities.sleepForXSeconds(2);
		}
		System.out.println("Driver closed successfully");
		
	}

}
