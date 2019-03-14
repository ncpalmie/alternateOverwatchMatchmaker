package alternateOverwatchMatchmaker;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebScraper {
	
	private static double pageLoadWaitTime = 0.95; //Temporary solution, will eventually use smarter way to ensure page loaded
	private  String[] pickRateDataTable = null;
	private String[] primaryStatsTable = null;
	private static WebDriver driver = setupDriver();
	private String baseUrl;
	private static final String XPATH_TO_ALPHA_SORT = "/html/body/div[1]/div[3]/div/div/div/div[2]/table/thead/tr/th[2]/a";
	private static final String XPATH_TO_TIME_FRAME = "/html/body/div[1]/div[3]/div/div/div/div[1]/div/div[1]/div[4]";
	private static final String XPATH_TO_PLATFORM = "/html/body/div[1]/div[3]/div/div/div/div[1]/div/div[2]/div[1]";
	private static final String XPATH_TO_GAMEMODE = "/html/body/div[1]/div[3]/div/div/div/div[1]/div/div[3]/div[2]";
	private static final String XPATH_TO_HEROTYPE = "/html/body/div[1]/div[3]/div/div/div/div[1]/div/div[4]/div[1]";
	private static final String XPATH_TO_RANKS = "/html/body/div[1]/div[3]/div/div/div/div[1]/div/div[5]/div";
	private static final String XPATH_TO_TABLE = "/html/body/div[1]/div[3]/div/div/div/div[2]/table/tbody";
	private static final String XPATH_TO_PRIMARY = "/html/body/div[1]/div[3]/div/div/div/div[2]/div/div[2]";
	private static final String XPATH_TO_OVERVIEW = "/html/body/div[1]/div[3]/div/div/div/div[2]/div/div[1]";
	private static final List<String> XPATHS_TO_CLICK = Arrays.asList(XPATH_TO_ALPHA_SORT, XPATH_TO_TIME_FRAME,
			XPATH_TO_PLATFORM, XPATH_TO_GAMEMODE, XPATH_TO_HEROTYPE);
	
	public WebScraper(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public void setupPage() {
		driver.get(baseUrl);
		findAndClickByXPath(WebScraper.XPATHS_TO_CLICK);
		//Need to click alpha sort twice to sort by alphabetically ascending
		findAndClickByXPath(WebScraper.XPATH_TO_ALPHA_SORT);
	}

	private static WebDriver setupDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\palmi\\IdeaProjects\\alternateOverwatchMatchmaker\\chromedriver.exe");
		ChromeOptions chromeOpts = new ChromeOptions();
		if (!Main.debug) {
			chromeOpts.addArguments("--headless");
		}
		WebDriver retDriver = new ChromeDriver(chromeOpts);

		return retDriver;
	}

	public boolean closeDriver() {
		driver.quit();
		if (((RemoteWebDriver) driver).getSessionId() == null) {
			return true;
		} else {
			return false;
		}
	}

	public float[] getPickRateArrayFor(int heroId) {
		int currTable = 0;
		float[] retArray = new float[7];
		
		if (pickRateDataTable == null) {
			int currRank = 2; //Initial rank starts at div[2] and final is at div[8]
			pickRateDataTable = new String[7];
			findAndClickByXPath(XPATH_TO_OVERVIEW);
			while (currRank <= 8) {
				findAndClickByXPath(XPATH_TO_RANKS + "[" + currRank + "]");
				pickRateDataTable[currRank - 2] = driver.findElement(By.xpath(XPATH_TO_TABLE)).getText();
				currRank++;
			}
		}
		
		while (currTable <= 6) {
			retArray[currTable] = Utilities.parseForPickRateById(heroId, pickRateDataTable[currTable]);
			currTable++;
		}
		
		return retArray;
	}

	//Will eventually be removed and implemented with above function using lambdas
	public Stats[] getAvgStatsFor(int heroId) {
		int currTable = 0;
		Stats[] retArray = new Stats[7];

		if (primaryStatsTable == null) {
			int currRank = 2; //Initial rank starts at div[2] and final is at div[8]
			primaryStatsTable = new String[7];
			findAndClickByXPath(XPATH_TO_PRIMARY);
			while (currRank <= 8) {
				findAndClickByXPath(XPATH_TO_RANKS + "[" + currRank + "]");
				primaryStatsTable[currRank - 2] = driver.findElement(By.xpath(XPATH_TO_TABLE)).getText();
				currRank++;
			}
		}

		while (currTable <= 6) {
			retArray[currTable] = Utilities.parseForStatsById(heroId, primaryStatsTable[currTable]);
			currTable++;
		}

		return retArray;
	}

	
	public boolean findAndClickByXPath(String xpath) {
		int clicks = 0;
		String pageBeforeClick = driver.getPageSource();
		WebElement element = driver.findElement(By.xpath(xpath));
		if (element.getAttribute("className").equals("filter-option selected")) {
			return true; //Element has already been selected, clicking is redundant
		}
		element.click();
		Utilities.sleepForXSeconds(WebScraper.pageLoadWaitTime); //Allow page to load
		while (driver.getPageSource().equals(pageBeforeClick) && clicks < 5) { //Attempt 5 clicks before giving up and failing
			element.click();
			Utilities.sleepForXSeconds(WebScraper.pageLoadWaitTime);
			clicks++;
		}
		if (driver.getPageSource().equals(pageBeforeClick)) {
			return false;
		}
		return true;
	}
	
	public boolean findAndClickByXPath(List<String> xpaths) {
		for(String xpath : xpaths) {
			if(!findAndClickByXPath(xpath)) {
				System.out.println("Error with xpath: " + xpath);
				return false;
			}
		}
		return true;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
