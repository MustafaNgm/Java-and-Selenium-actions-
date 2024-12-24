package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByClass {
	
	ChromeDriver driver ;

	@BeforeTest
	public void OpenURL () {
		
		driver = new ChromeDriver ();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		
	}
	
	@Test
	public void FindElementWithName () {
		try {
			WebElement UserName = driver.findElement(By.name("username"));
			WebElement password = driver.findElement(By.id("password"));
			WebElement loginbtn = driver.findElement(By.className("radius"));
			
			System.out.println(UserName.getTagName());
			System.out.println(password.getTagName());	
			System.out.println(loginbtn.getText());
			System.out.println(loginbtn.getTagName());
			
		} catch (NoSuchElementException e) {
			System.out.println("Element not found");
	
		}
	
	}
	
	@AfterTest
	public void Close () {
		
		//driver.quit();
	}
	
	

}
