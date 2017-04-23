package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import pages.LoginPage;
import pages.OrderPage;
import utilities.Config;
import utilities.ExcelUtils;
import utilities.Page;

public class CalculatePriceTest {

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
		//driver.close();
	}

	@Test
	public void test() {
		loginPage=new LoginPage(driver);
		loginPage.login(Config.getProperty("username"),
				        Config.getProperty("password"));
		orderPage=new OrderPage(driver);
		Page.verifyAtPage(orderPage.greeting);
		//Read values from Excel file
		ExcelUtils.openExcelFile(Config.getProperty("testdataPath"), 
				"TestData");
		int usedRowsCount=ExcelUtils.getUsedRowsCount();
		
		for(int rowNum=1;rowNum<usedRowsCount;++rowNum){
			
			if(!ExcelUtils.getCellData(rowNum, 0).equals("Y")){
				ExcelUtils.setCellData("Skip requested", rowNum, 3);
				continue;
			}
			
			String product=ExcelUtils.getCellData(rowNum, 1);
			String quantity=ExcelUtils.getCellData(rowNum, 2);
			
			
			Select prod=new Select(orderPage.product);
			prod.selectByVisibleText(product);
			
			orderPage.quantity.clear();
			orderPage.quantity.sendKeys(quantity);
			orderPage.calculate.click();
			
			String totalPrice=orderPage.totalPrice.getAttribute("value");
			System.out.println(totalPrice);
			
			ExcelUtils.setCellData(totalPrice, rowNum, 3);
			
		}

	}
}
