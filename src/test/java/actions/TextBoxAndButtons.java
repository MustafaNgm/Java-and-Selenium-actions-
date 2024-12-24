package actions;

import org.openqa.selenium.By; 

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TextBoxAndButtons {

	ChromeDriver driver ;

	@BeforeTest
	public void OpenURL () {

		driver = new ChromeDriver ();
		driver.navigate().to("http://3.218.233.93/login");
		System.out.println(driver.getCurrentUrl());

	}

	@Test
	public void WindowScreen() {
		
		driver.manage().window().maximize();
		
		}
	
	@Test
	public void loginScreen () {
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("admin@admin.com");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("123456789");
		
		//WebElement showpassword = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/form/div[2]/div/div/button/svg"));
		//showpassword.click();
		
		WebElement loginbutton = driver.findElement(By.id(":r3:"));
		loginbutton.click();
	}


	@Test
	 public void Companies () {
		
		WebElement companies = driver.findElement(By.cssSelector(""));
		companies.click();
		//System.out.println(driver.getTitle());
		
		WebElement viewBuilding = driver.findElement(By.xpath(""));
		viewBuilding.click();
		System.out.println(driver.getTitle());
		
	}
	
	

	//@AfterTest
	public void Close () {

	//	driver.quit();

	}
}
