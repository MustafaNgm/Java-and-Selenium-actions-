package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownList {

	FirefoxDriver driver ;

	@BeforeTest
	public void OpenURL () {
		


		driver = new FirefoxDriver ();
		driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
		System.out.println(driver.getCurrentUrl());
	}

	@Test

	public void dropdownlist() 
	

			throws InterruptedException {

		WebElement drobdown = driver.findElement(By.id("dropdown"));

		Select options = new Select(drobdown);

		Assert.assertEquals(3, options.getOptions().size());

		Assert.assertFalse(options.isMultiple());

		options.selectByIndex(1); 
		options.selectByValue("2");
		options.selectByVisibleText("Option 1");
		Assert.assertEquals("Option 1", options.getFirstSelectedOption().getText());

		Thread.sleep(3000);
		driver.manage().window().maximize();

	}

	@AfterTest
	public void Close () {
		

				//driver.quit();
	}
}