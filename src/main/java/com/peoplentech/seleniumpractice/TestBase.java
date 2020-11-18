package com.peoplentech.seleniumpractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    private static WebDriver driver;

    public static void navigateBack(){driver.navigate().back();}

    public static void clickOnElement(String element){driver.findElement(By.xpath(element)).click();}

    public static void setupDriver(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
    }
    public static void navigateToUrl(String url){driver.get(url);}

    public static void sleepFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void closeDriver(){driver.close();}
}
