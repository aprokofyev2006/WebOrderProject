package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;
import pages.OrderPage;
import utilities.Config;
import utilities.Page;

public class NegativeLoginTest {

	WebDriver driver;
	LoginPage loginPage;
	OrderPage orderPage;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty(Config.getProperty("webdriver") ,
				Config.getProperty("driverpath"));
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Config.getProperty("url"));
	}
	

	
	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test() {
		loginPage=new LoginPage(driver);
		loginPage.login("invalidUserId",
				        "invalidPassword");
		assertTrue(loginPage.loginError.isDisplayed());
		assertEquals("Invalid Login or Password.",
				loginPage.loginError.getText());
		
	}

}
