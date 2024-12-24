package findElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindELementsList {
	
	ChromeDriver driver ;

	@BeforeTest
	public void OpenURL () {
		
		driver = new ChromeDriver ();
		driver.navigate().to("https://the-internet.herokuapp.com");
		
	}
	@Test
	public void ElementsList () {
		
		//get all elements by tage name ( links )
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		
		System.out.println(Links.size());
		try {
			Assert.assertEquals(46, Links.size());
		} catch (AssertionError e) {
		
			System.out.println("Links not eql 40");
		}
		// after get links print the links value 
		for (WebElement Link : Links) {
			System.out.println(Link.getAttribute("href"));
			//open URL Link
			//driver.navigate().to( Link.getAttribute("href"));
			
		}
		
	}
	
	
	
	@AfterTest
	public void Close () {
		
		driver.quit();

}
}
