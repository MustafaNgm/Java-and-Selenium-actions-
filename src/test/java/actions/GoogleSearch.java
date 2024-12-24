package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class GoogleSearch {
	
	WebElement search ;
	
	ChromeDriver driver ;

	@BeforeTest
	public void OpenURL () {

		driver = new ChromeDriver ();
		driver.navigate().to("https://google.com");
		System.out.println(driver.getCurrentUrl());
	}
	
	
	@Test
	public void search () {
		
		search = driver.findElement(By.id("APjFqb"));
		search.sendKeys("mustafa");
		search.submit();// = enter button from keyboard
		
		search = driver.findElement(By.id("APjFqb"));
		search.clear();
		search.sendKeys("Mustafa Ngm");
		search.submit();
		
		WebElement Mustafa = driver.findElement(By.cssSelector("#rso > div:nth-child(2) > div > div > div.Z26q7c.UK95Uc.jGGQ5e > div > div > a > h3 > span"));
		Mustafa.click();
		
	}
	
	
	




//@AfterTest
public void Close () {

//	driver.quit();


	

}
}
