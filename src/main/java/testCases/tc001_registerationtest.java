package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Accountregister_page;
import pageObjects.Home_page;
import testBase.Baseclass;

public class tc001_registerationtest extends Baseclass
{

   @Test(groups= {"Regression" , "Master"})
	public void verify_reg_account()
	{
	   logger.info("Starting tc001...");  //you can use this everywhere in this class

		Home_page hp = new Home_page(driver);
		hp.clickMyaccount();
		hp.clickRegister();


		Accountregister_page reg = new Accountregister_page(driver);
		reg.Setname(randomString().toUpperCase());
		reg.name(randomString());
		reg.email(randomString()+"@gmail.com");
		reg.tele(randomNumber());

		//string number+alphanumeric
		String password = randomAlphaNumeric();
		reg.pass(password);
		reg.cpwd(password);

		// Accept Terms & Continue
		logger.info("Selecting radio button and accepting terms");
		reg.radioo();
		reg.cbox();
		reg.continuecta();

		//validation part
				String confmsg = reg.getConfirmationMsg();
				Assert.assertEquals(confmsg, "Your Account Has Been Created!");

				logger.info("Ending tc001...");

	}

}
