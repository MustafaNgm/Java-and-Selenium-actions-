package actions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragDrop {
	
	FirefoxDriver driver ;

	@BeforeTest
	public void OpenURL () {

		driver = new FirefoxDriver ();
		driver.navigate().to("http://cookbook.seleniumacademy.com/");
		System.out.println(driver.getCurrentUrl());
		WebElement OpenPage = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul/li[6]/a"));
		OpenPage.click();
	}

	@Test
	public void WindowScreen() {

		driver.manage().window().maximize();

	}


	@Test
	public void DragAndDrop() {
		
		WebElement Drag = driver.findElement(By.id("draggable"));
		WebElement Drop = driver.findElement(By.id("droppable"));
		
		Actions DragDropAcation = new Actions(driver);
		DragDropAcation.dragAndDrop(Drag, Drop).perform();;
		
		Assert.assertEquals("Dropped!", Drop.getText());
		

	}



	@AfterTest
	public void Close () {

			driver.quit();

	}
}
