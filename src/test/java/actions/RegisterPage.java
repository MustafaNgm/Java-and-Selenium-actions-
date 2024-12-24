package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterPage {
	
	ChromeDriver driver;
	@BeforeTest
	public void OpenURL () {

		driver = new ChromeDriver ();
		driver.navigate().to("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
	}

	@Test
	public void Register() {
		
			
		WebElement txt1 = driver.findElement(By.cssSelector("input.form-control[placeholder=\"First Name\"]"));
		txt1.sendKeys("Mustafa");
		WebElement txt2 = driver.findElement(By.cssSelector("input.form-control[placeholder=\"Last Name\"]"));
		txt2.sendKeys("Ngm");
		
		String FilePath = "C:\\Users\\NourTech\\Desktop\\Screen Shots\\Lightshot\\Screenshot_4.png";
		WebElement uploadFile = driver.findElement(By.id("imagesrc"));
		uploadFile.sendKeys(FilePath);
		//txt1.sendKeys("test");
	}
	public void close () {
		driver.quit();   
	}
}
