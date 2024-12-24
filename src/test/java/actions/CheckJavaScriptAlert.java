package actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckJavaScriptAlert {

	public class JavaScriptAlert {

		FirefoxDriver driver ;

		@BeforeTest
		public void OpenURL () {

			driver = new FirefoxDriver ();
			driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
			System.out.println(driver.getCurrentUrl());

		}

		@Test(priority = 1)
		public void TestAlert() {

			WebElement button = driver.findElement(By.id("simple"));
			button.click();
			// كدا فتحنا الالرت بعد كدا هنطلب منه ينتقل او يركز علي الالرت ال ظهر 
			Alert alert = driver.switchTo().alert();
			// نتاكد بقي من الرسالة ال ظهرت في الالرت
			//الي بيظهر text اول حاجه نخليه يعرف ال
			String alerttext = alert.getText();
			Assert.assertEquals("Hello! I am an alert box!", alerttext);
			System.out.println(alert.getText());
			alert.accept();
		}

		@Test(priority = 2)

		public void ConfirmAlert() {

			WebElement btn = driver.findElement(By.id("confirm"));
			WebElement Text = driver.findElement(By.id("demo"));
			btn.click();
			Alert alert = driver.switchTo().alert();
			//press on cancel
			alert.dismiss();
			System.out.println(Text.getText());
			btn.click();
			//press on ok
			alert.accept();
			System.out.println(Text.getText());
			Assert.assertEquals("You Accepted Alert!", Text.getText());
		}
		
		@Test(priority = 3)
		public void AlertSendKeys() {

			WebElement btn = driver.findElement(By.id("prompt"));
			btn.click();
			Alert alert = driver.switchTo().alert();
			alert.sendKeys("Mustafa Ngm");
			alert.accept();
			WebElement message = driver.findElement(By.id("prompt_demo"));
			Assert.assertEquals("Hello Mustafa Ngm! How are you today?", message.getText());
		}

		@AfterTest
		public void Close () {


			driver.quit();
		}
	}
}
