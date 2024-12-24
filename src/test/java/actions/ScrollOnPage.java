package actions;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollOnPage {
	
	public WebDriver driver ;

	@BeforeTest
	public void SetUp () {

		driver = new FirefoxDriver();
		driver.navigate().to("https://www.amazon.eg/ref=nav_logo");
		driver.manage().window().maximize();
	}
	
	@Test
	public void ScrollUsingJS() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("scrollBy(0,3000)");
		js.executeScript("scrollBy(3000,4300)");
		WebElement AmazonLogo = driver.findElement(By.cssSelector("div.nav-logo-base.nav-sprite"));
		Assert.assertTrue(AmazonLogo.isDisplayed());
		AmazonLogo.click();
		System.out.println(driver.getCurrentUrl());
		
		
	}

	
	@AfterClass
	public void CloseDriver() {
		driver.close();
	}
}
