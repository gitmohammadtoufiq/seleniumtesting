package Homework;

import org.testng.annotations.Test;

public class Cvs {
	//before
	@Test
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}
	@Test
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	@Test
	public void beforeClass() {
		System.out.println("beforeclass");
	}
	@Test
	public void beforeMethod() {
		System.out.println("beeforemethod");
	}
	@Test(dependsOnMethods="testone")
	public void test() {
		System.out.println("test one dependson");
	}
	
	
	//after 
	@Test
	public void afterSuite() {
		System.out.println("aftersuite");
	}
	@Test
	public void afterTest() {
		System.out.println("aftertest");
	}
	@Test
	public void afterClass() {
		System.out.println("afterclass");
	}
	@Test
	public void afterMethod() {
		System.out.println("aftermethod");
	}
	@Test	public void test2() {
		System.out.println("second test");

	}
	@Test(priority=2)
	public void test3() {
		System.out.println("third test");

	}
	@Test(priority=3)
	public void test4() {
		System.out.println("fourth test");

	}
	@Test(priority=0)
	public void test5() {
		System.out.println("fifth test");

	}
	
}
