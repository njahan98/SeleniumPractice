package com.peoplentech.seleniumpractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    public static void navigateBack(){driver.navigate().back();}

    public static void clickOnElement(String element){driver.findElement(By.xpath(element)).click();}

    public static void setupDriver(String browserName){
        if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
            driver = new FirefoxDriver();
        }else{
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void navigateToURL(String url){
        driver.get(url);
    }

    public static void sleepFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void closeDriver(){
        driver.close();
    }
}
