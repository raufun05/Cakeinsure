package org.saleforce.service.page.blog;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class IFrameBlogPostingPage {
	
	WebDriver driver;
	 
	 public IFrameBlogPostingPage(WebDriver driver){
	    	this.driver = driver;
	    	PageFactory.initElements(driver, this);
	    	
	  }
	
	@FindBy(linkText = "New Post") private WebElement linkButtonAppNewPost;
	@FindBy(xpath = "//*[@id='navbar']/span/ul/li/a") private WebElement linkButtonBackToIndex;
	@FindBy(xpath = "//*[@id='body']/div/div/div/form/div[1]/input") private WebElement textName;
	@FindBy(xpath = "//*[@id='body']/div/div/div/form/div[2]/input") private WebElement textCategories;
	@FindBy(xpath = "//*[@id='body']/div/div/div/form/div[3]/textarea") private WebElement textContent;
	@FindBy(xpath = "//*[@id='body']/div/div/div/form/button") private WebElement buttonSubmit;
	@FindBy(xpath = "//*[@id='body']/div/div/div/form/a") private WebElement buttonCancel;
	
	@FindBy(xpath = "//*[@id='body']/div/div/div") private WebElement panelPosting;
	
	
	public void clickLinkButtonBackToIndex() {
		linkButtonBackToIndex.click();
	}
	
	public void clickButtonCancel() {
		buttonCancel.click();
	}
	
	public void clickLinkButtonAppNewPost() {
		linkButtonAppNewPost.click();
	}
	
	
	public void createPost(Map<String, String> row) {
		
		textName.sendKeys(row.get("name"));
		textCategories.sendKeys(row.get("categorie"));
		textContent.sendKeys(row.get("content"));
		buttonSubmit.click();
	}
	
	public void verifyPost(Map<String, String> row, int i) {
		
		String xpath = "//*[@id='body']/div/div/div/ul/li["+ i+"]/a[1]/h3";
			  
		String text =	  driver.findElement(By.xpath(xpath)).getText();
			  
		if(text.equals(row.get("name"))) {
				  
			System.out.println("Verify is Pass for : " +row.get("name")); 
			 Reporter.log("Adding is Pass |" + row.get("name"));
			 
		}
		
	}
	 
	public void deletePost(Map<String, String> mp, int i) {
		
		String xpath = "//*[contains(text(),'Game "+ i+"')]";
		driver.findElement(By.xpath(xpath)).click();
		driver.findElement(By.xpath("//*[contains(text(),'Delete Post')]")).click();
	}
	
	public void viewPost(int i) {
		
		 String xpath = "//*[contains(text(),'Game "+ i+"')]";
		  driver.findElement(By.xpath(xpath)).click();
		  if( panelPosting.findElement(By.tagName("h3")).getText().startsWith("Game")) {
			  System.out.println("View Game pass : "); 
			  Reporter.log("View Game pass |");
		  }
		  
		  List<WebElement> cat= panelPosting.findElements(By.tagName("span"));
		  for(WebElement we: cat) {
			  if( we.getText().equals("Categories")){
				  System.out.println("View Categories pass : ");
				  Reporter.log("View Categories pass |");
			  }
			 if( we.getText().startsWith("Soccer")){
				  System.out.println("View Soccer Pass : " );
				  Reporter.log("View Soccer Pass |");
			  }
		  }
		  
		  if( panelPosting.findElement(By.tagName("p")).getText().startsWith("Play")) {
			  System.out.println("View Play Soccer pass : "); 
			  Reporter.log("View Play Soccer pass |");
		  }
	}
	
}
