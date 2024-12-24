package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WhatsApp {
	
	public class openWhatsApp {

		FirefoxDriver driver ;

		@BeforeTest
		public void OpenURL () {

			driver = new FirefoxDriver ();
			driver.navigate().to("https://www.facebook.com/");
			System.out.println(driver.getCurrentUrl());
			
		}
		
		
		@Test
		public void sendmessage (){
			
			WebElement Ashraf = driver.findElement(By.cssSelector("div.lhggkp7q:nth-child(13)"));
			Ashraf.click();
			WebElement entertext = driver.findElement(By.cssSelector("._3Uu1_"));
			entertext.sendKeys("ازيك ياد يا اشرف");
			WebElement send = driver.findElement(By.cssSelector("button.tvf2evcx > span:nth-child(1)"));
			send.click();
		}
		

}
	@AfterTest
	
	public void close (){
		
	}
}