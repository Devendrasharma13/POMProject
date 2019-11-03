package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class UserPreferencesPage extends BasePage{

	WebDriver driver;
	
	public UserPreferencesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getUserPreferencesPageTitle() {
		return driver.getTitle();
	}

	
}
