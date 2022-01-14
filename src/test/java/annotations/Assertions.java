package annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions {
	@Test
	public void checkTitle() {
		SoftAssert softassert=new SoftAssert();
		String expected="Electronics, Cars, Fashion, Collectibles & More | eBay";
		String expected2="Search";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
		String actual=driver.getTitle();
//		softassert.assertEquals(actual, expected2, "Title verification failed");
		
		Assert.assertEquals(actual, expected);
		String actual2=driver.findElement(By.xpath("//input[@id='gh-btn']")).getAttribute("value");
//		softassert.assertEquals(actual2, expected2, "Attribute verification verification failed");
				Assert.assertEquals(actual2, expected2);
		
	}
	
}
