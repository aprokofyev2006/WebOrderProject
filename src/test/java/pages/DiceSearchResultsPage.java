package pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiceSearchResultsPage {
private WebDriver driver;
	
	public DiceSearchResultsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
	}
	
	
	@FindBy(xpath="//h1[contains(text(),'jobs in')]")
//	@FindBy(className="h1 jobs-page-header-h1")
	public WebElement resultsLabel;
	
	@FindBy(id="posiCountId")
	public WebElement positionsCount;
	
	@FindBy(xpath="//a[starts-with(@id,'position')]")
	public List<WebElement> positionTitles;
	
	public boolean verifyResultsLabel(String jobTitle,String location){
		String resultsText=resultsLabel.getText();
		System.out.println(resultsText);
		
		if(resultsText.startsWith(jobTitle)&&resultsText.endsWith(location)){
			return true;
		}else{
			return false;
		}	
		
	}
}
