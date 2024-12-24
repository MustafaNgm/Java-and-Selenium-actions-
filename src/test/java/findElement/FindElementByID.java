package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByID {
	
	ChromeDriver driver ;

	@BeforeTest
	public void OpenURL () {
		
		driver = new ChromeDriver ();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		
	}
	
	@Test
	public void FindElementWithID () {
		
		WebElement UserName = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		
		System.out.println(UserName.getTagName());
		System.out.println(password.getTagName());		
	}
	
	@AfterTest
	public void Close () {
		
		driver.quit();
	}
	

}
