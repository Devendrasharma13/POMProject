package com.qa.hubspot.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class HomePageTest {
	
	BasePage basePage;
	HomePage homePage;
	LoginPage loginPage;
	Properties  prop;
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void getHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page title is "+title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void homePageHeaderTest() {
		Assert.assertTrue(homePage.isHomePageHeaderVisible());
	}
	
	@Test(priority = 3)
	public void getHomePageHeaderTextTest() {
		String text = homePage.getHomePageHeaderText();
		System.out.println("Home Page Header text is "+ text);
		Assert.assertEquals(text, Constants.HOME_PAGE_HEADER_TEXT);
	}
	
	@Test(priority = 4)
	public void AccountNameVisibleTest() {
		AssertJUnit.assertTrue(homePage.isHomePageHeaderVisible());
	}
	
	@Test(priority = 5)
	public void getAccountNameTest() {
		String accountName = homePage.getAccountNameText();
		System.out.print("Account name is "+accountName);
		Assert.assertEquals(accountName, prop.getProperty("account_name"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
