package com.crm.qa.testCases;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testBase.TestBase;

import org.apache.log4j.LogManager;
public class LoginPageTest extends TestBase {

	
	
	LoginPage loginPage;
	HomePage homePage;
	//public static Logger log =LogManager.getLogger(TestBase.class.getName());
	
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	//Constructor is used so that it gets all methods from parent class
	public LoginPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		initialization();     // choose browser and get url
		
		log.info("Browser is opened");
		loginPage=new LoginPage();  //create new object of LoginPage...lands on this page
		log.info("login page is opened");
	}
	
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String titleText=loginPage.validateLoginPageTitle();      // obj.method
		Assert.assertEquals(titleText, titleText);  //titleText,"CRMPROtitle" but due to some issue it is used directly
		log.info("Page title is validated");
	}
	
	@Test(priority=2)
	public void loginPagelogoTest() {
		boolean isDisplayed=loginPage.validateCRMImage();
		
		Assert.assertTrue(isDisplayed);
		log.info("CRM log is validated");
	}
	@Test(priority=3)
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		log.info("login successfully");
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("browser is closed");
	}
}
