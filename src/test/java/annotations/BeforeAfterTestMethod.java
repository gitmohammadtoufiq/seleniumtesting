package annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAfterTestMethod {
	@BeforeTest
	public void login() {
		System.out.println("login to the application");
	}
	@BeforeMethod
	public void connectDB() {
		System.out.println("Connect to DB");
	}
	@AfterMethod
	public void disconnectFromDB() {
		System.out.println("Disconnected from DB");
	}
	@Test(priority=1)
	public void test() {
		System.out.println("this is test1");
	}
	@Test(priority=2)
	public void test1() {
		System.out.println("this is test2");
	}
	@Test(priority=0)
	public void test2() {
		System.out.println("this is test3");
	}
	@AfterTest
	public void logout()
	{
		System.out.println("logout from the application");
	}
}
