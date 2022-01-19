package com.tej.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tej.base.TestBase;

public class PracticePage extends TestBase{
	@FindBy(id="userId")
	WebElement userEmail;
	
	@FindBy(id="pass")
	WebElement userPwd;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//*[local-name()='svg']")
	WebElement svg;
	
	@FindBy(xpath="//input[@name='test']")
	WebElement textbox;
	
	
	@FindBy(xpath="//a[contains(text(),'DownLoad Link')]")
	WebElement downloadLink;
	
	public PracticePage() {
		PageFactory.initElements(driver,this);
	}
	
	public void enterUser(String username,String password) {
		userEmail.sendKeys(username);
		userPwd.sendKeys(password);
		submit.click();
		svg.click();
		textbox.sendKeys("teju");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Set<String> windowHandles=driver.getWindowHandles();
		String parent=driver.getWindowHandle();
		downloadLink.click();
		Iterator it=windowHandles.iterator();
		it.next();
		System.out.println(driver.getTitle());
		driver.switchTo().window(parent);
	}
	
	
}
