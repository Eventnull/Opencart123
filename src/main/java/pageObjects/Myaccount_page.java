package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccount_page extends Basepage
{
   //constructor
	public Myaccount_page(WebDriver driver) {
		super(driver);
		
	}
	
	//xpath
	@FindBy(xpath = "//h2[contains(text(),'My Account')]") WebElement image;
	@FindBy(xpath = "(//a[@class='list-group-item'])[13]") WebElement logout; //added for step 6 ddt
	
	//action method 
	
	 public boolean Img()
	 { 
		 try {
		return image.isDisplayed();  
		 }
		 catch (Exception e) {
			return false;
		}
	
	 }
	 public void   logoutclick()
	 {
		 logout.click();
	 }
	 
	 
	 
	 
	 
	 
	
	 } 


