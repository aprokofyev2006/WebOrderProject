package utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void verifyAtPage(WebElement elem){
		Assert.assertTrue("Verify at correct page failed",elem.isDisplayed());
	}
	
	public static void waitUntilVisible(WebDriver driver,WebElement element){
		WebDriverWait wait = new WebDriverWait(driver,13);
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	
	
}
