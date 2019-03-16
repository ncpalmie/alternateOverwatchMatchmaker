package alternateOverwatchMatchmaker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hero { 
	
	private final String name;
	private final String heroType;
	private final int heroId;
	private final int health;
	private final int shield;
	private final int armor;
	private final float movementSpeed;
	private final float[] pickRateByRank;
	private final Stats[] avgStats;
	private final List<Hero> counters;
	private static final Map<String, Integer> NAME_TO_ID = setNameToIDMap();
	public static final String[] heroTypes = {"TANK", "OFFENSE", "DEFENSE", "SUPPORT"};
	private static WebScraper webscraper;
	private static List<Hero> heroList = null;
	
	public Hero(String name, String heroType, int heroId, int health, int shield, 
			int armor, float movementSpeed) {
		this.name = name;
		this.heroType = heroType;
		this.heroId = heroId;
		this.health = health;
		this.shield = shield;
		this.armor = armor;
		this.movementSpeed = movementSpeed;
		if (webscraper == null) {
			this.pickRateByRank = null;
			this.avgStats = null;
		}
		else {
			this.pickRateByRank = webscraper.getPickRateArrayFor(heroId);
			this.avgStats = webscraper.getAvgStatsFor(heroId);
		}
		this.counters = new ArrayList<Hero>();
	}
	
	public static int getHeroId(String name) {
		return NAME_TO_ID.get(name);
	}
	
	private static Map<String, Integer> setNameToIDMap() {
		Map<String, Integer> retMap = new HashMap<String, Integer>();
		retMap.put("Ana", 0);
		retMap.put("Ashe", 1);
		retMap.put("Bastion", 2);
		retMap.put("Brigitte", 3);
		retMap.put("D.Va", 4);
		retMap.put("Doomfist", 5);
		retMap.put("Genji", 6);
		retMap.put("Hanzo", 7);
		retMap.put("Junkrat", 8);
		retMap.put("Lucio", 9);
		retMap.put("McCree", 10);
		retMap.put("Mei", 11);
		retMap.put("Mercy", 12);
		retMap.put("Moira", 13);
		retMap.put("Orisa", 14);
		retMap.put("Pharah", 15);
		retMap.put("Reaper", 16);
		retMap.put("Reinhardt", 17);
		retMap.put("Roadhog", 18);
		retMap.put("Soldier: 76", 19);
		retMap.put("Sombra", 20);
		retMap.put("Symmetra", 21);
		retMap.put("Torbjorn", 22);
		retMap.put("Tracer", 23);
		retMap.put("Widowmaker", 24);
		retMap.put("Winston", 25);
		retMap.put("Hammond", 26);
		retMap.put("Zarya", 27);
		retMap.put("Zenyatta", 28);
		return Collections.unmodifiableMap(retMap);
	}
	
	public static List<Hero> setupDefaultHeroList(WebScraper scraper) {
		/*Values for movement speed were taken from this reddit post, they reflect the average
		speed of each character over 100 seconds which should be a better representation of 
		how quickly characters move over their base speeds which don't account for abilities
		Reddit post: https://www.reddit.com/r/OverwatchUniversity/comments/8r7tz9/another_extensive_analysis_on_character_movement/
		*/
		Hero.webscraper = scraper;
		List<Hero> retList = new ArrayList<Hero>();
		retList.add(new Hero("Ana", "SUPPORT", 0, 200, 0, 0, 5.5f));
		retList.add(new Hero("Ashe", "OFFENSE", 1, 200, 0, 0, 7.86f));
		retList.add(new Hero("Bastion", "DEFENSE", 2, 200, 0, 100, 5.5f));
		retList.add(new Hero("Brigitte", "SUPPORT", 3, 200, 500, 50, 5.99f));
		retList.add(new Hero("D.Va", "TANK", 4, 650, 0, 200, 7.6f));
		retList.add(new Hero("Doomfist", "OFFENSE", 5, 250, 0, 0, 10.39f));
		retList.add(new Hero("Genji", "OFFENSE", 6, 200, 0, 0, 7.51f));
		retList.add(new Hero("Hanzo", "DEFENSE", 7, 200, 0, 0, 6.47f));
		retList.add(new Hero("Junkrat", "DEFENSE", 8, 200, 0, 0, 6.82f));
		retList.add(new Hero("Lucio", "SUPPORT", 9, 200, 0, 0, 12.35f));
		retList.add(new Hero("McCree", "OFFENSE", 10, 200, 0, 0, 5.99f));
		retList.add(new Hero("Mei", "DEFENSE", 11, 250, 0, 0, 5.5f));
		retList.add(new Hero("Mercy", "SUPPORT", 12, 200, 0, 0, 11.23f));
		retList.add(new Hero("Moira", "SUPPORT", 13, 200, 0, 0, 8.48f));
		retList.add(new Hero("Orisa", "TANK", 14, 200, 900, 200, 5.5f));
		retList.add(new Hero("Pharah", "OFFENSE", 15, 200, 0, 0, 6.9f));
		retList.add(new Hero("Reaper", "OFFENSE", 16, 250, 0, 0, 7.94f));
		retList.add(new Hero("Reinhardt", "TANK", 17, 300, 200, 2000, 5.92f));
		retList.add(new Hero("Roadhog", "TANK", 18, 600, 0, 0, 5.5f));
		retList.add(new Hero("Soldier: 76", "OFFENSE", 19, 200, 0, 0, 8.33f));
		retList.add(new Hero("Sombra", "OFFENSE", 20, 200, 0, 0, 10.89f));
		retList.add(new Hero("Symmetra", "SUPPORT", 21, 100, 100, 0, 5.5f));
		retList.add(new Hero("Torbjorn", "DEFENSE", 22, 200, 0, 0, 6.2f));
		retList.add(new Hero("Tracer", "OFFENSE", 23, 150, 0, 0, 8.7f));
		retList.add(new Hero("Widowmaker", "DEFENSE", 24, 200, 0, 0, 7.86f));
		retList.add(new Hero("Winston", "TANK", 25, 400, 600, 200, 9.69f));
		retList.add(new Hero("Hammond", "TANK", 26, 500, 0, 100, 15.0f));
		retList.add(new Hero("Zarya", "TANK", 27, 200, 200, 0, 6.26f));
		retList.add(new Hero("Zenyatta", "SUPPORT", 28, 50, 150, 0, 5.5f));
		heroList = retList;
		return retList;
	}
	
	public static List<Hero> getHeroList() {
		return heroList;
	}
	
	public float[] getPickRateArray() {
		return pickRateByRank;
	}
	
	public static void printHeroInfo(int startHeroId, int endHeroId) {
		for(int i = startHeroId; i <= endHeroId; i++) {
			
		}
	}

	public String getName() {
	    return name;
    }

    public String getHeroType() {
	    return heroType;
    }

    public int getHeroId() {
	    return heroId;
    }

    public int getHealth() {
	    return health;
    }

    public int getShield() {
	    return shield;
    }

    public int getArmor() {
	    return armor;
    }

    public float getMovementSpeed() {
	    return movementSpeed;
    }

    public float[] getPickRateByRank() {
        return pickRateByRank;
    }

    public List<Hero> getCounters() {
        return counters;
    }

    public Stats[] getAvgStats() {
        return avgStats;
    }

    @Override
	public String toString() {
		String retString = "";
		retString += this.name + "\n";
		retString += "Hero Type: " + this.heroType + "\n";
		retString += "Hero Id: " + this.heroId + "\n";
		retString += "Hero Health: " + this.health + "\n";
		retString += "Hero Shield: " + this.shield + "\n";
		retString += "Hero Armor: " + this.armor + "\n";
		retString += "Hero Average Movement Speed: " + this.movementSpeed + "\n";
		retString += "Hero Pick Rates (by rank):\n";
		retString += "    Bronze: " + this.pickRateByRank[0] + "\n";
		retString += "    Silver: " + this.pickRateByRank[1] + "\n";
		retString += "    Gold: " + this.pickRateByRank[2] + "\n";
		retString += "    Platinum: " + this.pickRateByRank[3] + "\n";
		retString += "    Diamond: " + this.pickRateByRank[4] + "\n";
		retString += "    Master: " + this.pickRateByRank[5] + "\n";
		retString += "    Grandmaster: " + this.pickRateByRank[6] + "\n";
		retString += "Hero Average Stats (by rank):\n";
		retString += "    Bronze: " + this.avgStats[0].toString() + "\n";
		retString += "    Silver: " + this.avgStats[1].toString() + "\n";
		retString += "    Gold: " + this.avgStats[2].toString() + "\n";
		retString += "    Platinum: " + this.avgStats[3].toString() + "\n";
		retString += "    Diamond: " + this.avgStats[4].toString() + "\n";
		retString += "    Master: " + this.avgStats[5].toString() + "\n";
		retString += "    Grandmaster: " + this.avgStats[6].toString() + "\n";
		retString += "Counters: ";
		for (Hero hero : this.counters) {
			retString += hero.name + " ";
		}
		retString += "\n";
		
		return retString;
	}
}
