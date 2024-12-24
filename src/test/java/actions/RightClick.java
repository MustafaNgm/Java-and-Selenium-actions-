package actions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RightClick {

	FirefoxDriver driver ;

	public class openWhatsApp {

		@BeforeTest
		public void OpenURL () {

			driver = new FirefoxDriver ();
			driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo/fontawesome-icons.html");
			driver.manage().window().maximize();
			System.out.println(driver.getCurrentUrl());
		}
	}

	@Test
	public void rightclick() {
		//span element
		WebElement ClickMeBTN = driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
		//li element
		WebElement ListEditBTN = driver.findElement(By.cssSelector("li.context-menu-item.context-menu-icon.context-menu-icon--fa.fa.fa-edit"));

		Actions action = new Actions(driver);
		action.contextClick(ClickMeBTN).moveToElement(ListEditBTN).click().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Alert alert = driver.switchTo().alert();
		// نتاكد بقي من الرسالة ال ظهرت في الالرت
		//الي بيظهر text اول حاجه نخليه يعرف ال
		String alerttext = alert.getText();
		Assert.assertEquals("clicked: edit", alerttext);
		System.out.println(alert.getText());
		alert.dismiss();
	} 

	@AfterTest
	public void Close () {
		driver.quit();
	}
}
