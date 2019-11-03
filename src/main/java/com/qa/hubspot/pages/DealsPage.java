package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;

public class DealsPage {

	WebDriver driver;
	
	public DealsPage() {
		this.driver = driver;
	}
	/**
	 * this is for create deal
	 */
	public void createDeal() {
		System.out.println("create deal...");
	}
	
	public String getDealPageTitle() {
		return driver.getTitle();
	}
	
	public void printFun(){
		System.out.println("Hello World!");
	}
	
	public void homepage_url(){
	}

	public void homepage_masterurl(){
	}

	
}
