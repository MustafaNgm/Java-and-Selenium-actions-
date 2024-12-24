package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByCSSSelector {


	FirefoxDriver driver ;

	@BeforeTest
	public void OpenURL () {

		driver = new FirefoxDriver ();
		driver.navigate().to("https://the-internet.herokuapp.com/login");

	}

	@Test
	public void ElementByCSS () {

		WebElement loginBTN = driver.findElement(By.cssSelector("button.radius"));
		WebElement name = driver.findElement(By.cssSelector("input#username"));
		WebElement password = driver.findElement(By.cssSelector("div.row"));
		WebElement header = driver.findElement(By.cssSelector("h2"));
		
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
