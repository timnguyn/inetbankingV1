package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(5000);
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		logger.info("providing customer details...");
		addcust.custName("Pavan");
		addcust.custgender("Male");
		addcust.custdob("10", "15", "1985");
		Thread.sleep(5000);
		addcust.custaddress("India");
		addcust.custcity("Hyd");
		addcust.custstate("AP");
		addcust.custpinno("500074");
		addcust.custtelephoneno("9089897545");
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(5000);
		logger.info("validation started....");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("test case failed");

		}
	}
		
}
