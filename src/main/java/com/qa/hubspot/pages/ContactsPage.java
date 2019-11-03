package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.hubspot.base.BasePage;

public class ContactsPage extends BasePage{

	WebDriver driver;
	
	//By header = By.cssSelector("hi.private-header__heading");
	By header = By.xpath("//i18n-string[contains(text(),'Contacts')]");
	By createContactButton = By.xpath("//span[text()='Create contact']");
	
	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	By createContactFormButton = By.xpath("//div[contains(text(),'Create contact')]");
	
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getContactsPageHeader() {
		return driver.findElement(header).getText();	
	}
	
	public void createNewContact(String emailId, String fn, String ln, String jt) {
		driver.findElement(createContactButton).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(email).sendKeys(emailId);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(firstName).sendKeys(fn);
		driver.findElement(lastName).sendKeys(ln);
		driver.findElement(jobTitle).sendKeys(jt);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Actions action = new Actions(driver);
		action.click(driver.findElement(createContactFormButton)).build().perform();
		//driver.findElement(createContactFormButton).click();
	}
}
