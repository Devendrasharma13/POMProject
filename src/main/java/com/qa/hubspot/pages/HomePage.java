package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementActions;

public class HomePage extends BasePage {
	
	WebDriver driver;
	ElementActions elementActions;
	
	// locators/OR
	By header = By.cssSelector("h1.private-header__heading");
	By accountName = By.cssSelector("a#account-menu>span");
	By accountMenu = By.xpath("//a[@id='account-menu']");
	By linkProfile = By.xpath("//div[@class='user-info-preferences']");
	
	// For Contacts Page 
	By contactsMainTab = By.id("nav-primary-contacts-branch");
	By contactsChildTab = By.id("nav-secondary-contacts");
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(driver);
	}
	
	//page actions
	public String getHomePageTitle() {
		return elementActions.waitForPageTitle(Constants.HOME_PAGE_TITLE);
	}
	
	public boolean isHomePageHeaderVisible() {
		return elementActions.isElementDisplayed(header);
	}
	
	public String getHomePageHeaderText() {
		return elementActions.doGetText(header);
	}
	
	public boolean isAccountNameVisible() {
		return elementActions.isElementDisplayed(accountName);
	}
	
	public String getAccountNameText() {
		return elementActions.doGetText(accountName);
	}
	
	public UserPreferencesPage profilePrefences() {
		driver.findElement(accountMenu).click();
		driver.findElement(linkProfile).click();
		
		return new UserPreferencesPage(driver);
	}
	
	public ContactsPage goToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	private void clickOnContacts() {
		elementActions.doClick(contactsMainTab);
		elementActions.doClick(contactsChildTab);
	}
}
