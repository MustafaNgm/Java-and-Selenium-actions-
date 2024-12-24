package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByLink {

	
	ChromeDriver driver ;

	@BeforeTest
	public void OpenURL () {
		
		driver = new ChromeDriver ();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		
	}
	
	@Test
	public void tixtlinkText () {
		
		WebElement ElementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
		System.out.println(ElementalSelenium.getAttribute("href"));
		
	}
	
	@Test
	public void tixtlinkPartialText () {
		
		WebElement ElementalSelenium2 = driver.findElement(By.partialLinkText("Elemental"));
		System.out.println(ElementalSelenium2.getAttribute("href"));
	}
	
	@AfterTest
	public void Close () {
		
		driver.quit();

}
	
}
