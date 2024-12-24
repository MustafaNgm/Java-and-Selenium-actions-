package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByXpath {



	FirefoxDriver driver ;

	@BeforeTest
	public void OpenURL () {

		driver = new FirefoxDriver ();
		driver.navigate().to("https://the-internet.herokuapp.com/login");

	}

	@Test
	public void ElementByXpath () {

		WebElement loginBTN = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button"));
		WebElement name = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement header = driver.findElement(By.xpath("/html/body/div[2]/div/div/h2"));

		System.out.println(loginBTN.getText());
		System.out.println(name.getTagName());
		System.out.println(password.getTagName());
		System.out.println(header.getText());

	}


	@AfterTest
	public void Close () {

		driver.quit();

	}
}
