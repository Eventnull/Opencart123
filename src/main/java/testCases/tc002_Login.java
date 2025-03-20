package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home_page;
import pageObjects.Login_page;
import pageObjects.Myaccount_page;
import testBase.Baseclass;

public class tc002_Login  extends Baseclass

{
	@Test(groups= {"Sanity" , "Master"})
	public void veify_login()
	{
		
		logger.info("......Started testcase 2 .........");
		
		try {
		//Homepage
		Home_page hp = new Home_page(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		
		//Loginpage
		Login_page lp = new Login_page(driver);
		lp.Email(p.getProperty("Email"));
		lp.Password(p.getProperty("passwor"));
		lp.Login();
		
		//MYaccount
		Myaccount_page map = new Myaccount_page(driver);
	    boolean targetpage = map.Img();
	    
	    //assertion creation for accountpage 
	    
	    Assert.assertEquals(targetpage, true);
	    
		}
		catch (Exception e) {
			Assert.fail();
		}
		
	    
	    logger.info(".............Ended testcase 2..........");
		
	}
	
}
