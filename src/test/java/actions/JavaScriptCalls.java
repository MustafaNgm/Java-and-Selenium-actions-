package actions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class JavaScriptCalls {

	public WebDriver driver ;

	@BeforeTest
	public void SetUp () {

		driver = new FirefoxDriver();
		driver.navigate().to("https://www.google.com");
		driver.manage().window().maximize();
	}

	@Test
	public void TestJavaScript() {
		//get google title using java script 
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		String Title = (String) js.executeScript("return document.title");
		assertEquals(Title, "Google");
		System.out.println(Title);

		//get all links using JS
		@SuppressWarnings("unchecked")
		List<String> linkTexts = (List<String>) js.executeScript("var links = document.getElementsByTagName('a'); " +
				"var linkTexts = []; " +
				"for (var i = 0; i < links.length; i++) { " +
				"   linkTexts.push(links[i].innerText); " +
				"} " +
				"return linkTexts;");
		String joinedLinks = String.join(" & ", linkTexts);
		System.out.println(joinedLinks);
		
		//get number of links 
		Long Links = (Long) js.executeScript("var links = document.getElementsByTagName('a'); return links.length");
		assertEquals(Links, 19);
		System.out.println(Links);

	}

	@AfterClass
	public void CloseDriver() {
		driver.close();
	}
}
