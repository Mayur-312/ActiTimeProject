package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;       //Global variable to use this web-driver methods in every methods.
	FileLibrary f=new FileLibrary();      //Global variable 
	
	@BeforeSuite
	public void DatabaseConnection() {
		Reporter.log("DataBase connected succesfully",true);
	}
	
	@AfterSuite
	public void DatabaseDisconnection() {
		Reporter.log("Database disconnected succesfully",true);
	}
	
	@BeforeClass
	public void LaunchBrowser() throws IOException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		 driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String URL = f.ReadDataFromPropertyFile("url");
		driver.get(URL);
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.close();
		Reporter.log("Browser is closed",true);
	}
	
	@BeforeMethod
	public void Login() throws IOException {
		String UN=f.ReadDataFromPropertyFile("username");  // username and password taken from property file using file library class and store in a variable.
		String PW = f.ReadDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);    // object created for pom class login and use methods created in pom class to find elements
		lp.getUntbx().sendKeys(UN);
		lp.getPwtbx().sendKeys(PW);
		lp.getLgbtn().click();
		
		Reporter.log("Logged in successfully");
	}
	
	@AfterMethod
	public void LogOut() {
		driver.findElement(By.id("logoutLink")).click();
	}

}
