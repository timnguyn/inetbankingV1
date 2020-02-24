package com.inetbanking.testCases;
import java.io.IOException;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
//import org.testng.annotations.Test;
//import com.inetbanking.pageObjects.LoginPage;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest__001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException 
	{
		driver.get(baseURL);
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
		Assert.assertTrue(true);
		logger.info("Login test passed");
		}
		else 
		{
		captureScreen(driver,"logintest");
		Assert.assertTrue(false);
		logger.info("Login test failed");
		}
	}
}