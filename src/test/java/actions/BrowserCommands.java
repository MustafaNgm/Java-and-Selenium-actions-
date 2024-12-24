package actions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserCommands {

	
	ChromeDriver driver ;

	@BeforeTest
	public void OpenURL () {
		
		driver = new ChromeDriver ();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		System.out.println(driver.getCurrentUrl());
		
	}
	
	@Test
	public void TestBrowserCommands () throws InterruptedException {
		driver.manage().window().maximize();
	//	driver.manage().window().fullscreen();
	//	driver.manage().window().minimize();
		
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		
		
	}
	
	
	@AfterTest
	public void Close () {
		
		driver.quit();

}
}
