package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//constructor
public class Accountregister_page extends Basepage

{
	public Accountregister_page(WebDriver driver)
	{
		super(driver);
	}


	//locator
	@FindBy(xpath = "//input[@name='firstname']") WebElement name;
	@FindBy(xpath = "//input[@placeholder='Last Name']") WebElement lastname;
	@FindBy(xpath = "//input[@placeholder='E-Mail']") WebElement email;
	@FindBy(xpath = "//input[@placeholder='Telephone']") WebElement Telephone;
	@FindBy(xpath = "//input[@placeholder='Password']") WebElement passwoed;
	@FindBy(xpath = "//input[@name='confirm']") WebElement confirm_password;
	@FindBy(xpath = "(//input[@name='newsletter'])[1]") WebElement radio_yes;
	@FindBy(xpath = "//input[@type='checkbox']") WebElement checked_policy;
	@FindBy(xpath = "//input[@class='btn btn-primary']") WebElement cont_cta;
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")  WebElement message;

    // Action Methods (Using Method Overloading)

   public void	Setname(String name1)
   {
	   name.sendKeys(name1);
   }

   public void name(String lastname1) {
	   lastname.sendKeys(lastname1);
	   }

    public void email(String email1)
    {
    	email.sendKeys(email1);
    }
    public void tele(String Telephone1)
    {
    	Telephone.sendKeys(Telephone1);
    }

	public void pass(String pwd)
	{
		passwoed.sendKeys(pwd);
	}
	public void cpwd(String cpwd)
	{
		confirm_password.sendKeys(cpwd);
	}

	public void radioo()
	{

		radio_yes.click();
	}

	public void cbox()
	{
		checked_policy.click();
	}

	public void continuecta()
	{
		cont_cta.click();
	}


//validation

	public String getConfirmationMsg() {
        try {
            return message.getText(); // Fetch confirmation message
        } catch (Exception e) {
            System.out.println("Didn't get confirmation message.");
            return "Message not found";  // Return a default message
        }
    }
	}

































	/*for click cta "Solutions"
	//sol1
	btncontinue.click();
	//sol2
	btncontinue.submit();
	//sol3
	javascriptExecutor js(javascriptexecutor)driver
	js.executescript("arguments[0].click()",btncontinue)
	//sol4
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
	wait.until(ExpectedCondition.elementtoBeClickable(btnContinue)).click();
	//sol5
	btnContinue.sendKeys(Keys.RETURN);
     //sol6-->Useful if the button is inside a dropdown or needs hovering.
	Actions act = new Actions(driver);
	act.moveToElement(btnContinue).click().perform();
*/
