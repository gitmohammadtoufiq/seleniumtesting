package seleniumMethods;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get(" https://www.ebay.com/");
		Thread.sleep(1000);	
		driver.manage().window().maximize();
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[5]/a"));
		Actions action=new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(ele).perform();
		

	}

}
