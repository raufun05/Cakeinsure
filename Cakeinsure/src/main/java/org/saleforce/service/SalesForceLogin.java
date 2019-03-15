package org.saleforce.service;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SalesForceLogin {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.firefox.marionette", "C:\\\\Users\\Raufun\\eclipse-workspace\\ignitionn\\geckodriver.exe");
	      
		  WebDriver driver = new FirefoxDriver();
		  
		  driver.get("https://login.salesforce.com");
		  
		  driver.findElement(By.name("username")).sendKeys("interviewtest@cakeinsure.com");
		  
		  driver.findElement(By.name("pw")).sendKeys("InterviewCak3!");
		  
		  driver.findElement(By.id("Login")).click();
		  
		/*  try {
			Thread.sleep(500000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		  
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  
		   
		  driver.findElement(By.xpath("//*[@id='oneHeader']/div[3]/div/div[1]/div[1]/nav/button")).click();
		  
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
				    
		  //System.out.println("khan: " +driver.findElement(By.xpath("//*[@id='appTile' and ]")).getText());
		  
		  driver.findElement(By.xpath("//*[@id='appTile' and text()='Marketing']")).click();
		  
		  
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  
		 // driver.switchTo().alert().dismiss();
		  
		  //int size2 = driver.findElements(By.tagName("iframe")).size();

		  //driver.switchTo().frame(1);

		  
		 // System.out.println("khan2: " +size2);
		  
		  driver.findElement(By.xpath("//*[@class='slds-truncate' and text()= 'Blog']")).click();
		  
		  //driver.findElement(By.xpath("//*[@id='oneHeader']/div[3]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[9]/a/span")).click();
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		 // driver.switchTo().alert().dismiss();
			
		// System.out.println("khan: " +driver.findElement(By.linkText("New Post")).getText());
		  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         // driver.findElement(By.linkText("New Post")).click();
          //driver.findElement(By.xpath("//*[@id='body']/div/div/div/form/a ")).click();
          
          driver.switchTo().frame(0);
		  
		 		  
		  for(int i=1; i<4; i++) {
			  
			  driver.findElement(By.linkText("New Post")).click();
			  
			 // int size = driver.findElements(By.tagName("iframe")).size();
			  
			 // System.out.println("khan: " +size);
			 // driver.findElement(By.xpath("//*[@href='#/posts/new']")).click();
			  
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			  
			 // driver.switchTo().alert().dismiss();
			  
			//*[@id='body']/div/div/div/form/div[1]/input
			  
			  driver.findElement(By.xpath("//*[@id='body']/div/div/div/form/div[1]/input")).sendKeys("Game " + i);
			
			  driver.findElement(By.xpath("//*[@id='body']/div/div/div/form/div[2]/input")).sendKeys("Soccer " + i);
			  
			  driver.findElement(By.xpath("//*[@id='body']/div/div/div/form/div[3]/textarea")).sendKeys("Play Soccer " + i);
			
			  driver.findElement(By.xpath("//*[@id='body']/div/div/div/form/button")).click();
			  
		  }
		  
	
	
	
	 for(int i= 2; i< 5; i++) {
		  
		  String xpath = "//*[@id='body']/div/div/div/ul/li["+ i+"]/a[1]/h3";
		  
		  String text =	  driver.findElement(By.xpath(xpath)).getText();
		  
		  if(text.startsWith("Game")) {
			  
			System.out.println("Adding is Pass for : " +text); 
		  }
		  
	  }
		   
		  
		  for(int i= 1; i< 4; i++) {
			  
			  String xpath = "//*[contains(text(),'Game "+ i+"')]";
			  
			  driver.findElement(By.xpath(xpath)).click();
			  driver.findElement(By.xpath("//*[contains(text(),'Delete Post')]")).click();
			  
		  }
		  
		  for(int i= 2; i< 5; i++) {
			  
			  String xpath = "//*[@id='body']/div/div/div/ul/li["+ i+"]/a[1]/h3";
			  
			 
			  
			  if(!driver.findElement(By.xpath(xpath)).isDisplayed()) {
				  
				System.out.println("Pass : " +xpath); 
			  }
			  
		  }
			 
		  
		
	}
	
	
	
	}
