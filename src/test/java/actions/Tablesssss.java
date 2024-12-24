package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tablesssss {

	ChromeDriver driver ;

	@BeforeTest
	public void OpenURL () {

		driver = new ChromeDriver ();
		driver.navigate().to("https://the-internet.herokuapp.com/tables");
		System.out.println(driver.getCurrentUrl());
	}

	@Test

	public void table () {

		WebElement table1 = driver.findElement(By.id("table1"));
		//Get all rows using this element
		List<WebElement> rows = table1.findElements(By.tagName("tr"));
		//Make sure they are 5
		Assert.assertEquals(5 , rows.size());

		for (WebElement row : rows) {

			List<WebElement> columns = row.findElements(By.tagName("td"));
			for (WebElement column : columns) {

				System.out.println(column.getText());

			}

			System.out.println();
		}

	}


	@AfterTest
	public void Close () {

		driver.quit();
	}

}
