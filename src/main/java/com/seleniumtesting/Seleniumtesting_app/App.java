package com.seleniumtesting.Seleniumtesting_app;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
    	//System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
    	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
       // DesiredCapabilities cp = new DesiredCapabilities();
       // cp.setCapability(ChromeOptions.CAPABILITY, options);
        //options.merge(cp);
        WebDriver driver = new ChromeDriver(options);
        
        System.out.println("Selenium Test Scripts Execution Started..");
        
        //Open Browser and enter the Url
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get("http://3.93.68.243:8082/addressbook/");
        //Click on new contact buttons
        driver.findElement(By.className("v-button")).click();
        //enter all the details
        driver.findElement(By.id("gwt-uid-5")).sendKeys("Bhaskar");
        Thread.sleep(1000);
        driver.findElement(By.id("gwt-uid-7")).sendKeys("p");
        Thread.sleep(1000);
        driver.findElement(By.id("gwt-uid-9")).sendKeys("998989");
        Thread.sleep(1000);
        driver.findElement(By.id("gwt-uid-11")).sendKeys("bhaskara@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("gwt-uid-13")).sendKeys("1/02/2023,");
        Thread.sleep(1000);
        //Click on save to store all the infomation
        driver.findElement(By.className("v-button-primary")).click();
        
        Thread.sleep(1000);
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
    	
    	File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
    	
    	File destFile = new File("C://Users//Bhaskar//OneDrive//Documents//Test-Reports//test-report.jpg");
    	
    	FileUtils.copyFile(srcFile, destFile);
    	
    	Thread.sleep(5000);
        
        driver.quit();
        
        System.out.println("Script executed Successfully");

    }
}
