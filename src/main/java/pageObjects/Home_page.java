package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//using inheritence concepts
public class Home_page extends Basepage

{

//constructor
public Home_page(WebDriver driver)
	{
		super(driver);
	}

//validation

@FindBy(xpath = "//span[contains(text(),'My Account')]") WebElement account;
@FindBy(xpath = "//a[contains(text(),'Register')]") WebElement register;
@FindBy(xpath = "//a[contains(text(),'Login')]") WebElement login;



//actionmethod //your are not pass any string type

public void clickMyaccount()
{
	account.click();
}

public void clickRegister()
{
	register.click();
}

public void clickLogin()
{
	login.click();
}


}
