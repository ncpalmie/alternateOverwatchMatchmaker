package alternateOverwatchMatchmaker;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Main {
	
	public static boolean debug = true;

	public static void main(String[] args){
		WebScraper.setupPage();

		WebScraper.findAndClickByXPath(WebScraper.XPATHS_TO_CLICK);
		//Needs to be clicked twice because who would want to sort alphabetically ascending like a sane person
		WebScraper.findAndClickByXPath(WebScraper.XPATH_TO_ALPHA_SORT);
		
		List<Hero> heroes = Hero.getHeroList();
		System.out.println(heroes.get(0).toString());
		
		while(!WebScraper.closeDriver()) {
			System.out.println("Failed to close driver, trying again...");
			Utilities.sleepForXSeconds(2);
		}
		System.out.println("Driver closed successfully");
		
	}

}
