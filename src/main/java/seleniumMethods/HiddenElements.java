package seleniumMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenElements {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get(" http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		Thread.sleep(3000);	
		driver.manage().window().maximize();
		//int x=driver.findElement(By.xpath("//input[@id='male']")).getLocation().getX();
		//int y=driver.findElement(By.xpath("//input[@id='male']")).getLocation().getY();
		
//		System.out.println("x cordinate is "+x);
//		System.out.println("y cordinate is "+ y);
		
		List<WebElement>elements=driver.findElements(By.id("male"));
		
		int total=elements.size();
		
		for(int i=0; i<total; i++) {
			
			int x=elements.get(i).getLocation().getX();
			
			if(x!=0) {
				elements.get(i).click();
				break;
			}
		}
		
		

	}

}
