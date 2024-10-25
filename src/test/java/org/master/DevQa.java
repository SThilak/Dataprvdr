package org.master;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DevQa {
	public static WebDriver driver;

	
	@DataProvider (name = "Credentials")
		public Object[][] getData() {
			return new Object[][] {
				{"innovationprinces","rajarani"},
				{"innovationPrincess","rajarani"},
				{"innovationprinces","raajarani"},
				{"innovationPrinces","rajarani"},
				{" ","rajarani"}
			};		
		    }
	@Test(dataProvider = "Credentials")
	public void login (String user, String pass) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(user);
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(pass);
		Thread.sleep(2000);
		driver.findElement(By.id("login")).click();
	}	
	@AfterClass 
	public static void takesscreen(String Adactin) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Source, new File("C:\\Users\\D E L L\\Desktop\\ts\\Adactinpage=.png"));
		System.out.println("Correction Done");
	}
}
