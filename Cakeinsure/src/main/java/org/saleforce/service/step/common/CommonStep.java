package org.saleforce.service.step.common;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.saleforce.service.page.LogInPage;
import org.saleforce.service.page.NavigationPage;

import cucumber.api.java.en.Given;

public class CommonStep{
	
	
	static {
    	
    	System.setProperty("webdriver.firefox.marionette", "\\Cakeinsure\\lib\\geckodriver.exe");
    }
	
	public static WebDriver driver = new FirefoxDriver();
	
	
	public static long timeOut_max = 60;
	public static long timeOut_min = 30;
	
	//private static Logger Log = Logger.getLogger(Log.class.getName());

	
	public static LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
	public static NavigationPage navigationPage = PageFactory.initElements(driver, NavigationPage.class);
	
	
	@Given("^I am on the application home page on URL \"([^\"]*)\"$")
	public void i_am_on_the_application_home_page_on_URL(String url) throws Throwable {
	    
		//driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeOut_max, TimeUnit.SECONDS);


		driver.navigate().to(url);

	    
	}
	
	
	@Given("^I login in with user name \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_login_in_with_user_name_and_password(String userName, String password) throws Throwable {
		
		logInPage.login(userName, password);
		driver.manage().timeouts().implicitlyWait(timeOut_max, TimeUnit.SECONDS);
		
	    
	}

	@Given("^I Navigate to \"([^\"]*)\" Blog$")
	public void i_Navigate_to_Blog(String arg1) throws Throwable {
		navigationPage.clickButtonAppLauncher();
		driver.manage().timeouts().implicitlyWait(timeOut_min, TimeUnit.SECONDS);
		navigationPage.clickLinkButtonAppMarketing();
		driver.manage().timeouts().implicitlyWait(timeOut_min, TimeUnit.SECONDS);
		navigationPage.clickLinkButtonBlog();
		driver.manage().timeouts().implicitlyWait(timeOut_min, TimeUnit.SECONDS);
	    
	}
	
}
