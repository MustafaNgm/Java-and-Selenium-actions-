package actions;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WaitActions {

	public WebDriver driver ;

	@BeforeTest
	public void openurl () {

		driver = new FirefoxDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void TestImplicityWait () {

		driver.findElement(By.xpath("/html/body/div[1]/div[1]/ul/li[4]/a")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement Message = driver.findElement(By.id("page4"));
		assertTrue(Message.getText().contains("Nunc nibh tortor"));


	}

	@Test(priority = 1)
	public void TestExplicityWait() {


		driver.get("https://www.google.com/");
		WebElement search = driver.findElement(By.id("APjFqb"));
		search.sendKeys("selenium driver");
		search.submit();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.titleContains("selenium"));
		assertTrue(driver.getTitle().toLowerCase().contains("selenium"));
		System.out.println(driver.getTitle());


	}

	@AfterClass
	public void CloseDriver() {
		driver.close();
	}
}

