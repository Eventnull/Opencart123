package pageObjects;

//we did this for to achive reusability constructor
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Basepage  {

	WebDriver driver;
	public Basepage(WebDriver  driver)
	{
		PageFactory.initElements(driver, this);
	}

}
