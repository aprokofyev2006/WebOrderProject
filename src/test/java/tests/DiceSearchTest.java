package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.DiceHomePage;
import pages.DiceSearchResultsPage;
import utilities.Config;
import utilities.Page;

public class DiceSearchTest {
	
	WebDriver driver;
	DiceHomePage diceHomePage;
	DiceSearchResultsPage diceSearchResultPage; 

	@Before
	public void setUp() throws Exception {
		System.setProperty(Config.getProperty("webdriver") ,
				Config.getProperty("driverpath"));
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Config.getProperty("diceurl"));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String jobTitle="Automation Engineer";
		String location="Chicago, IL";
		diceHomePage=new DiceHomePage(driver);
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(), "Tech Jobs | US Contract and Permanent IT Jobs | Dice.com");
		
		diceHomePage.search(jobTitle, location);
		diceSearchResultPage=new DiceSearchResultsPage(driver);
		
		diceSearchResultPage.verifyResultsLabel(jobTitle, location);
		assertTrue(diceSearchResultPage.verifyResultsLabel(jobTitle, location));
		
		
//		WebDriverWait wait = new WebDriverWait(driver,13);
//		wait.until(ExpectedConditions.visibilityOf(diceSearchResultPage.positionsCount));
		
		Page.waitUntilVisible(driver, diceSearchResultPage.positionsCount);
		
		String resultsCount=diceSearchResultPage.positionsCount.getText();
		int iresultsCount=Integer.parseInt(resultsCount);
		System.out.println(resultsCount);
		assertTrue(iresultsCount>0);
		
		System.out.println(diceSearchResultPage.positionTitles.size());
		
		List<String> positions=new ArrayList<String>();
		
		
		for (WebElement position : diceSearchResultPage.positionTitles) {
			if(position.isDisplayed()){
				positions.add(position.getText());
				
			}
		}
		
		System.out.println(positions.size());
		
		//Sort the arrayList then print
		Collections.sort(positions);
		
		for(String pos:positions){
			System.out.println(pos);
		}
		
	}

}
