package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_page  extends Basepage

{
  //constructor  1
	public Login_page(WebDriver driver) { //this is constructor
		super(driver);
		
	}
	
	//xpath 2
	@FindBy(xpath = "//input[@placeholder ='E-Mail Address']") WebElement emailaddress;
	@FindBy(xpath = "//input[@id='input-password']") WebElement password;
	@FindBy(xpath = "//input[@type='submit']") WebElement Login;
	
	
	//action method 3
	
	public void Password(String pass_word)
	{
		password.sendKeys(pass_word);
	}
	
	public void Email(String email)
	{
		emailaddress.sendKeys(email);
	}
	
	public void Login()
	{
		Login.click();
	}
	

}