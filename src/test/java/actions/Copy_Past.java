package actions;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Copy_Past {
	ChromeDriver driver;

	

	@BeforeTest
	public void openurl () throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://soundcloud.com/mustafa-ngm");
		Thread.sleep(3000);

	}

	
	@Test(priority = 1 )
	public void pastvalue() throws InterruptedException {
		WebElement text = driver.findElement(By.className("emptyNetworkPage__headline"));
		WebElement Search =driver.findElement(By.className("headerSearch__input"));
		WebElement accept = driver.findElement(By.id("onetrust-accept-btn-handler"));
		accept.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var range = document.createRange();"
                         + "range.selectNode(arguments[0]);"
                         + "window.getSelection().removeAllRanges();"
                         + "window.getSelection().addRange(range);", text);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		Search.click();
		Search.sendKeys(Keys.CONTROL + "v");
		Search.submit();
		Thread.sleep(2000);
	}
	
//	@Test(priority = 2)
//public void ScrollUsingJS() throws InterruptedException {
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver ;
//		js.executeScript("scrollBy(0,3000)");
//		js.executeScript("scrollBy(3000,0)");
//		
//	
//		Thread.sleep(2000);
//	}
		
		@Test(priority = 3)
		public void play() {
			WebElement music = driver.findElement(By.cssSelector("div.soundTitle__playButton > a.sc-button-play.playButton.sc-button.sc-button-xlarge"));
			music.click();
		}
		
		
	}
