package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestFrames {

	public WebDriver driver ;

	@BeforeTest
	public void SetUp () {

		driver = new FirefoxDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Frames.html");
		driver.manage().window().maximize();
	}

	@Test
	public void TestFramesWithIDorName() {
		driver.switchTo().frame("left");
		WebElement Text = driver.findElement(By.tagName("p"));
		System.out.println(Text.getText());
		Assert.assertEquals("This is Left Frame", Text.getText());
		//it's important
		driver.switchTo().defaultContent();

		driver.switchTo().frame("right");
		WebElement Text2 = driver.findElement(By.tagName("p"));
		System.out.println(Text2.getText());
		Assert.assertEquals("This is Right Frame", Text2.getText());
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		WebElement Text3 = driver.findElement(By.tagName("p"));
		System.out.println(Text3.getText());
		Assert.assertEquals("This Frame doesn't have id or name", Text3.getText());
		driver.switchTo().defaultContent();
		
	}

	@AfterClass
	public void CloseDriver() {
		driver.close();
	}
}
