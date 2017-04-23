package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(id="ctl00_MainContent_status")
	public WebElement loginError;
	
	@FindBy(id="ctl00_MainContent_username")
	public WebElement usernameInputBox;
	
	@FindBy(id = "ctl00_MainContent_password")
	public WebElement passwordInputBox;
	
	@FindBy(id = "ctl00_MainContent_login_button")
	public WebElement loginButton;
	
	@FindBy(xpath="//label[.='Username:']")
	public WebElement userNameLabel;
	
	@FindBy(xpath="//label[.='Password:']")
	public WebElement passwordLabel;
	
	public void login(String userName,String password){
		usernameInputBox.sendKeys(userName);
		passwordInputBox.sendKeys(password);
		loginButton.click();
	}
	
}
