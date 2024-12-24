package actions;

import static org.testng.Assert.assertEquals;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class MultipleWindowsTest {

	public WebDriver driver ;

	@BeforeTest
	public void SetUp () {

		driver = new FirefoxDriver();
		driver.navigate().to("https://cookbook.seleniumacademy.com/Config.html");
		driver.manage().window().maximize();
	}
	
	@Test(priority = 0)
	public void TestWindowUsingTitle () {
	//store window handle of parent window
		String MyFristWindow = driver.getWindowHandle();
		driver.findElement(By.id("visitbutton")).click();
	//get all windows titles
		for (String WindowID : driver.getWindowHandles()) {
			String Title = driver.switchTo().window(WindowID).getTitle();
		
	//get page your want by if Condition
			if (Title.equals("Visit Us")) {
	//work and actions on your selected page
			assertEquals("Visit Us", driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			driver.close();
			break;
			
			}
			
		}
		driver.switchTo().window(MyFristWindow);
		
	}
	
	@Test(priority = 1)
	public void TestWindowUsingName () {
		String MyFristWindow = driver.getWindowHandle();
		driver.findElement(By.id("helpbutton")).click();
		driver.switchTo().window("HelpWindow");
		assertEquals("Help", driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		WebElement text = driver.findElement(By.xpath("/html/body/div/h3"));
		System.out.println(text.getText());
		driver.close();
		driver.switchTo().window(MyFristWindow);
		
	}
	
	@AfterClass
	public void CloseDriver() {
		driver.close();
	}
}
