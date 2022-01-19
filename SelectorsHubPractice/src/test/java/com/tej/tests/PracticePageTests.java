package com.tej.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tej.base.TestBase;
import com.tej.pages.PracticePage;

public class PracticePageTests extends TestBase {

	PracticePage practicePage;
	public PracticePageTests() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		init();
		practicePage=new PracticePage();
	}
	
	@Test
	public void practiceTest() {
		practicePage.enterUser("tej.vanama@gmail.com", "Password");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
