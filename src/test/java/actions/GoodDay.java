package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoodDay {

	public class DropDownList {

		FirefoxDriver driver ;

		@BeforeTest
		public void OpenURL () {

			driver = new FirefoxDriver ();
			driver.navigate().to("https://www.goodday.work/my-tasks");
			System.out.println(driver.getCurrentUrl());
		}
		@Test
		public void Login () throws InterruptedException {
			
			
			WebElement LoginPage = driver.findElement(By.cssSelector("a.menu-item:nth-child(3)"));
			LoginPage.click();
			
			WebElement data = driver.findElement(By.name("email"));
			WebElement data2 = driver.findElement(By.name("password"));
			WebElement loginbtn = driver.findElement(By.cssSelector(".login-button"));
			
			data.sendKeys("mustafangm1212@gmail.com");
			data2.sendKeys("MustafaNgm12");
			loginbtn.click();
			Thread.sleep(6000);

		}
		
		@Test
		public void Select () {
			
			WebElement Select = driver.findElement(By.className("organization-logo s80 gd-c-6"));
			Select.click();
		}
		
	
	}
}
