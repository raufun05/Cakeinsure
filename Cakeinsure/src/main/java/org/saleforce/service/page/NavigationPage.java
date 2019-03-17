package org.saleforce.service.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NavigationPage {
	
	WebDriver driver;
	 
	 public NavigationPage(WebDriver driver){
	    	this.driver = driver;
	    	PageFactory.initElements(driver, this);
	  }
	
	@FindBy(xpath = "//*[@id='oneHeader']/div[3]/div/div[1]/div[1]/nav/button") private WebElement buttonAppLauncher;
	@FindBy(xpath = "//*[@id='appTile' and text()='Marketing']") private WebElement linkButtonAppMarketing;
	@FindBy(xpath = "//*[@class='slds-truncate' and text()= 'Blog']") private WebElement linkButtonBlog;
	
	
	public void clickButtonAppLauncher() {
		
		buttonAppLauncher.click();
	}
	
	public void clickLinkButtonAppMarketing() {
		
		linkButtonAppMarketing.click();
	}
	public void clickLinkButtonBlog() {
	
		linkButtonBlog.click();
	}

}
