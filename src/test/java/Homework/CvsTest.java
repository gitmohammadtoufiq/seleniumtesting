package Homework;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CvsTest {
	static WebDriver driver;
	String browser = "chrome";
	


	//Browser open
	@BeforeMethod
	public void browserOpen() {

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/shajib/Documents/study/QA/development/java/Exercise/testing/chromedriver");
			driver = new ChromeDriver();
		}
		
		
		else {
			System.out.println("Browser not supported");
		}

		driver.get("https://www.cvs.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	//1st case | Click Shop button
	@Test
	public void shopNav() {
		driver.findElement(By.xpath("//ul[@class='main-nav']//a[contains(text(), 'Shop')]")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//2nd case doesn't work without iterator but can make it work by adding here
//			driver.findElement(By.xpath("//*[@id=\"addv-shop-cat2\"]/div[1]/ul/li[4]/a")).click();
	}

	//2nd case | selecting "Household" through for for loop and conditional statement
	@Test
	public void householdNav() {
		List<WebElement> searchResults = driver.findElements(By.xpath("//nav[@id='addv-shop-cat2']//div[@class='row hidden-for-table-mobile']//child::ul//li"));
		System.out.println(searchResults.size());

		for(int i = 0; i < searchResults.size(); i++) {
			String searchIteams = searchResults.get(i).getText();
			if(searchIteams.contains("Household")) {
				searchResults.get(i).click();
				break;
			}
		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	//3rd case | number of link
	@Test
	public void linksCount() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int linksCount = links.size();

		System.out.println("Total number of links on this page is " + linksCount);

		for(int i = 1; i < linksCount; i++) {
			WebElement storage = links.get(i);
			String linksAttribute = storage.getAttribute("href");
			System.out.println(linksAttribute);
			verifyLinkActive(linksAttribute);
		}
	}

	// 3rd case extends | broken links
	private static void verifyLinkActive(String linksAtt) {
		try {
			URL linksAttribute = new URL(linksAtt);
			HttpURLConnection httpURLConnect = (HttpURLConnection)linksAttribute.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();

			if(httpURLConnect.getResponseCode() == 200) {
				System.out.println(linksAtt + " - " + httpURLConnect.getResponseMessage());
			}

			if(httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linksAtt + " - " + httpURLConnect.getResponseCode() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
			}
		} 
		catch(Exception e) {

		}

	}


	@AfterMethod
	public void browserClose() {
		driver.close();
	}

}
