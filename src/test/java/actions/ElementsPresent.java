package actions;

import org.openqa.selenium.By; 
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ElementsPresent {

	public class CheckBoxs {

		ChromeDriver driver ;

		@BeforeTest
		public void OpenURL () {

			driver = new ChromeDriver ();
			driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
			System.out.println(driver.getCurrentUrl());
		}
		
		// كدا التيستاية دي هتكون واقفة مش هترن
		//@Test (enabled = false)

		@Test //كدا ترن
		
		public void dropdownlist() 

		// لتاخير وقت ال رن للكود ال عليه الدور يتنفذ
				throws InterruptedException {

			WebElement checkbox1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]"));
			checkbox1.click();

			WebElement checkbox2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]"));
			if (checkbox2.isSelected()) {
				checkbox2.click();
				System.out.println("selected successfully");
			}

		}

		@Test

		public void testiselementpresent () {

			// لو الايليمينت موجود هتروح تجيبه وبعدين لو لقيته مش سيليكتيد دوس عليه
			if (isElementSelection(By.xpath("//*[@id=\"checkboxes\"]/input[1]"))) {
				WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
				if (!checkbox.isSelected()) {
					checkbox.click();

				}

			} else { Assert.fail("check box not exist");

			}
		}


		//هنا عاوز يرجعلي ترو او فولس في حالة ان الايليمينت موجود او لا 	
		

@Test
		private boolean isElementSelection (By by) {

			try { driver.findElement(by) ;
			return true ;


			} catch ( NoSuchElementException e) {
				return false ;

			}

		}



		@AfterTest
		public void Close () {


			//driver.quit();
		}
	}
}
