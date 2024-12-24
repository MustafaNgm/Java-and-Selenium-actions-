package actions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Do {
	ChromeDriver driver;



	@BeforeTest
	public void Login() throws InterruptedException{

		driver = new ChromeDriver ();

		driver.navigate().to("http://svg.ixerp.tech/login");

		WebElement Email = driver.findElement(By.id("login_email"));
		Email.sendKeys("administrator");
		WebElement pass = driver.findElement(By.id("login_password"));
		pass.sendKeys("1");
		WebElement Login = driver.findElement(By.cssSelector("button.btn.btn-sm.btn-primary.btn-block.btn-login"));
		Login.click();
		Thread.sleep(2000);

	}

	@Test 
	public void loginsuccess () {
		try { 
			String URL = driver.getCurrentUrl();
			if (URL.contains("http://svg.ixerp.tech/app")) {
	            System.out.println("Success");
	        } else {
	            System.out.println("Fail");
			}

		} catch (Exception e) {

			System.out.println("Break Down");
		}
	}

	@AfterTest
	public void exit () {

		driver.quit();
	}
}
