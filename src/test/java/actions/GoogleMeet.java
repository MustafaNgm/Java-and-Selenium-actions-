package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleMeet {

	public class openWhatsApp {

		FirefoxDriver driver ;

		@BeforeTest
		public void OpenURL () {

			driver = new FirefoxDriver ();
			driver.navigate().to("https://meet.google.com/");
			System.out.println(driver.getCurrentUrl());
		}
		
		
		@Test
		public void sendmessage (){
			
			WebElement Ashraf = driver.findElement(By.cssSelector("div.primary-meet-cta:nth-child(4) > div:nth-child(1) > a:nth-child(1) > button:nth-child(1)"));
			Ashraf.click();
			WebElement entertext = driver.findElement(By.cssSelector("#identifierId"));
			entertext.sendKeys("mustafangm1212@gmail.com");
			WebElement send = driver.findElement(By.cssSelector(".VfPpkd-LgbsSe-OWXEXe-k8QpJ"));
			send.click();
		}
		

}
	@AfterTest
	
	public void close (){
		
	}

}
