package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.UserPreferencesPage;
import com.qa.hubspot.util.Constants;

public class UserPreferencesPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	UserPreferencesPage userPreferencesPage;
	
	@BeforeMethod()
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		userPreferencesPage = homePage.profilePrefences();		
	}
	
	@Test(priority = 1)
	public void getUserPreferencesPageTitleTest() {
		String  title = userPreferencesPage.getUserPreferencesPageTitle();
		System.out.println("User Preferences Page title is "+title);
		Assert.assertEquals(title, Constants.USER_PREFENCES_PAGE_TITLE);
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
