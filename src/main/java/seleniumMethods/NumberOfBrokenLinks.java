package seleniumMethods;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NumberOfBrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/mohammadtoufiq/eclipse-workspace/SeleniumTesting/chromedriver");
		WebDriver driver=new ChromeDriver();
		//driver.get("https://demo.guru99.com/test/newtours/");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total number of links are:" +links.size());
		
		for(int i=0; i<links.size();i++) {
			WebElement elements=links.get(i);
			String url=elements.getAttribute("href");
			
			URL names=new URL(url);
			
			HttpURLConnection httpcon=(HttpURLConnection) names.openConnection();
			Thread.sleep(2000);
			httpcon.connect();
			
			int res_code=httpcon.getResponseCode();
			
			if (res_code>=400) {
				System.out.println(url +" is a broken link");
			}
			else {
				System.out.println(url+" is a valid link");
			}
			
			
			
			
			
			
		}
	}

}
