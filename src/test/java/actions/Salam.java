package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Salam {
	ChromeDriver driver ;

	public class Profile {



		@BeforeTest
		public void OpenURL () {

			driver = new ChromeDriver ();
			driver.navigate().to("https://svg.datavalue.solutions/#login");
			System.out.println(driver.getCurrentUrl());
			driver.manage().window().maximize();
		}
	}

	@Test(priority = 1)
	public void login() {

		WebElement UserName = driver.findElement(By.id("login_email"));
		UserName.sendKeys("mg@mg.com");
		WebElement pass = driver.findElement(By.id("login_password"));
		pass.sendKeys("123");
		WebElement btn = driver.findElement(By.cssSelector(".btn-login"));
		btn.click();
		
		
	}

	@Test(priority = 2)
	public void ddl () throws InterruptedException {
		
		
		

		Thread.sleep(5000);
		
        WebElement dropdown = driver.findElement(By.cssSelector(".icon.icon-xs"));
        dropdown.click();

        WebElement myProfileItem = driver.findElement(By.cssSelector(".nav-item.dropdown-navbar-user .avatar-frame"));
        myProfileItem.click();
        WebElement myProfileLink = driver.findElement(By.xpath("//a[@class='dropdown-item' and contains(text(),'My Profile')]"));
        myProfileLink.click();
        
        myProfileItem.click();
        WebElement mySettings = driver.findElement(By.xpath("//a[@class='dropdown-item' and contains(text(),'My Settings')]"));
        mySettings.click();
       
        WebElement search = driver.findElement(By.id("navbar-search"));
        search.sendKeys("Ngm");
        
        Actions actions = new Actions(driver);
        actions.moveToElement(search).perform();


	}
	
	
	@Test(priority = 3 )
	
	public void changeimage () throws InterruptedException {
		
		Thread.sleep(8000);
		
		Actions actions = new Actions(driver);
		WebElement imageElement = driver.findElement(By.cssSelector(".sidebar-image"));
		actions.moveToElement(imageElement).perform();
		
		WebElement changeLink = driver.findElement(By.cssSelector(".dropdown.open.dropdown-toggle"));
        changeLink.click();
		
        
        WebElement uploadLink = changeLink.findElement(By.cssSelector(".sidebar-image-change"));
        uploadLink.click();
        
        Thread.sleep(5000);
        WebElement removeLink = changeLink.findElement(By.cssSelector(".sidebar-image-remove"));
        removeLink.click();
        
	}





	//@AfterTest
	public void Close () {

		//	driver.quit();

	}
}


