package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClickAction {

	public class DropDownList {

		FirefoxDriver driver ;

		@BeforeTest
		public void OpenURL () {

			driver = new FirefoxDriver ();
			driver.navigate().to("http://cookbook.seleniumacademy.com/");
			System.out.println(driver.getCurrentUrl());
		}
		@Test
		public void opendubleclickpage () {

			WebElement DubleClick = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul/li[5]/a"));
			DubleClick.click();

		}

		@Test

		public void performDoubleClickAction() {
			WebElement messageElement = driver.findElement(By.id("message"));
			Actions action = new Actions(driver);
			action.doubleClick(messageElement).perform();
		}
		
		
		
		@AfterTest
		public void Close () {

			//driver.quit();

		}
	}

}
