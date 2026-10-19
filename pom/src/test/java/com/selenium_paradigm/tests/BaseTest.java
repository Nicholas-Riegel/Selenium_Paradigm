package com.selenium_paradigm.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    protected void setUp(){
        
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("--incognito");

        if ("true".equals(System.getenv("HEADLESS"))) {

            options.addArguments("--headless=new");
        }
        
        driver.set(new ChromeDriver(options));
        
        getDriver().get("https://www.saucedemo.com");
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown(){
    
        if (getDriver() != null ){ 
            
            try {

                getDriver().quit();
            
            } finally {

                driver.remove();
            }
        }
    }

    protected WebDriver getDriver(){

        return driver.get();
    }
}
