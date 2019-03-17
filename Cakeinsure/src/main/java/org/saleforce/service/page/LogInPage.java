package org.saleforce.service.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LogInPage {
	
	WebDriver driver;
	 
	 public LogInPage(WebDriver driver){
	    	this.driver = driver;
	    	PageFactory.initElements(driver, this);
	  }
	
	@FindBy(name = "username") private WebElement textUserName;
	@FindBy(name = "pw") private WebElement textUserPassword;
	@FindBy(id = "Login") private WebElement buttonUserLogin;
	
	
	public void login(String userId, String password) {
		
		textUserName.sendKeys(userId);
		textUserPassword.sendKeys(password);
		buttonUserLogin.click();
		
		Reporter.log("Log In Successful |");
		
	
	}

}
