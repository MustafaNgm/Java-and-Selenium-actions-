package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByTagName {
	
	ChromeDriver driver ;

	@BeforeTest
	public void OpenURL () {
		
		driver = new ChromeDriver ();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		
	}
	
	@Test
	public void ElementByTagName () {
		
		WebElement LoginBTN = driver.findElement(By.tagName("button"));
		LoginBTN.click();
		
	}
	
	
	@AfterTest
	public void Close () {
		
		driver.quit();

}

}
