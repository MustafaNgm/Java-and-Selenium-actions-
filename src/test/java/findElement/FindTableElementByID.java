package findElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindTableElementByID {

	ChromeDriver driver ;

	@BeforeTest
	public void OpenURL () {
		
		driver = new ChromeDriver ();
		driver.navigate().to("https://the-internet.herokuapp.com/tables");
		
	}
	
	@Test
	public void FindTable () {
		
		WebElement Table = driver.findElement(By.id("table1"));
		List<WebElement> rows = Table.findElements(By.tagName("tr"));
		System.out.println(rows.get(3).getText());
		
	}
	
	
	@AfterTest
	public void Close () {
		
		driver.quit();

}
}
