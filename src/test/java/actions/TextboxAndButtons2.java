package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextboxAndButtons2 {


	ChromeDriver driver ;

	@BeforeTest
	public void OpenURL () {

		driver = new ChromeDriver ();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		System.out.println(driver.getCurrentUrl());
	}

	@Test
	public void Login () {

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");
		WebElement loginbtn = driver.findElement(By.className("radius"));
		loginbtn.click();
		
		// muck sure the element have a success message text
		WebElement successtext = driver.findElement(By.id("flash"));
		System.out.println(successtext.getText());
		Assert.assertTrue(successtext.getText().contains("You logged into a secure area!"));

		
		//System.out.println(successmessage.getText());
		//Assert.assertTrue(successmessage.getText().contains("partner"));
	}




	@AfterTest
	public void Close () {

		//	driver.quit();

	}
}
