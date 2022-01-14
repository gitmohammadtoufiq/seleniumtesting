package seleniumMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/mohammadtoufiq/eclipse-workspace/SeleniumTesting/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/slider/#colorpicker");
		driver.manage().window().maximize();
		
		
				
		Thread.sleep(2000);
		
		WebElement ele=driver.findElement(By.xpath("//iframe[@src=\"/resources/demos/slider/colorpicker.html\"]"));
		driver.switchTo().frame(ele);
		Thread.sleep(2000);
		
		Actions action=new Actions(driver);
		WebElement names=driver.findElement(By.id("swatch"));
		action.contextClick(ele).perform();
		

	}

}
