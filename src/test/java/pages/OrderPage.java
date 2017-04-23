package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage{
	private WebDriver driver;
	
	public OrderPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(className="login_info")
	public WebElement greeting;
	
	@FindBy(id = "ctl00_logout")
	public WebElement logOut;

	@FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
	public WebElement product;

	@FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
	public WebElement quantity;

	@FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
	public WebElement totalPrice;

//	@FindBy(className = "submit")
//	public WebElement submitButton;
//	
	@FindBy(css="input[value='Calculate']")
	public WebElement calculate;
	


}
