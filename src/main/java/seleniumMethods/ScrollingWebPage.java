package seleniumMethods;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ScrollingWebPage {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.cvs.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		//1.scrolling page by using pixel
//		js.executeScript("window.scrollBy(0,2000)", "");
		
		//2.scrolling page till we find element
		WebElement scroll=driver.findElement(By.xpath("//a[text()='Shop now']"));
		js.executeScript("arguments[0].scrollIntoView();",scroll);
	
		//3. scroll page till bottom 
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

}
