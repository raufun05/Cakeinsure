package org.saleforce.service.step.blog;

import java.sql.Driver;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.saleforce.service.page.LogInPage;
import org.saleforce.service.page.NavigationPage;
import org.saleforce.service.page.blog.IFrameBlogPostingPage;
import org.saleforce.service.step.common.CommonStep;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Blog {
	
	public static IFrameBlogPostingPage iFrameBlogPostingPage = PageFactory.initElements(CommonStep.driver, IFrameBlogPostingPage.class);
	
	
	@When("^I Create Multiple Post$")
	public void i_Create_Multiple_Post(DataTable table) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		
		List <Map<String, String>> dataTableList = table.asMaps(String.class, String.class);
		
		CommonStep.driver.switchTo().frame(0);
		
		for(Map<String, String> row: dataTableList) {
			
			iFrameBlogPostingPage.clickLinkButtonAppNewPost();
			CommonStep.driver.manage().timeouts().implicitlyWait(CommonStep.timeOut_min, TimeUnit.SECONDS);
			iFrameBlogPostingPage.createPost(row);
			
		}
	   
	}

	@Then("^I verify Multiple Post is created$")
	public void i_verify_Multiple_Post_is_created(DataTable table) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		
		List <Map<String, String>> dataTableList = table.asMaps(String.class, String.class);
		
		
		int i=2;
		for(Map<String, String> row: dataTableList) {
			
			
			iFrameBlogPostingPage.verifyPost(row, i);
			
			i++;
			
		}
	   
	}
	
	
	@When("^I click Multiple Post I view all post$")
	public void i_click_Multiple_Post_I_view_all_post(DataTable table) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		
		List <Map<String, String>> dataTableList = table.asMaps(String.class, String.class);
		
		
		int i=1;
		for(Map<String, String> row: dataTableList) {
			
			
			iFrameBlogPostingPage.viewPost(i);
			
			i++;
			iFrameBlogPostingPage.clickLinkButtonBackToIndex();
			
		}
	    
	}

	@When("^I click Delete Post I Delete all post$")
	public void i_click_Delete_Post_I_Delete_all_post(DataTable table) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		
		List <Map<String, String>> dataTableList = table.asMaps(String.class, String.class);
		
		
		int i=1;
		for(Map<String, String> row: dataTableList) {
			
			
			iFrameBlogPostingPage.deletePost(row, i);
			
			i++;
			
			
		}
		CommonStep.driver.quit();	    
	}

}
