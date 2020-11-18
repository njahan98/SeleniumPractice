package com.peoplentech.seleniumpractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium2 {
    public static void main(String[] args) throws InterruptedException {
        userShouldBeAbleToClickOnSignInAndRegister();
    }
    private static WebDriver driver; //private bc only needed in this specific class
    public static void userShouldBeAbleToClickOnSignInAndRegister(){
        //open the browser
        setupDriver();
        //navigate to the url
        navigateToUrl("https://www.ebay.com");
        //wait 2 seconds
        sleepFor(2);
        //click on sign-in
        clickOnElement("(//a[text()='Sign in'])[1]");
        //wait 2 seconds
        sleepFor(2);
        //navigate back
        navigateBack();
        // wait 2 seconds
        sleepFor(2);
        //click on register
        clickOnElement("(//a[text()='register'])");
        //wait 2 seconds
        sleepFor(2);
        //close the browser
        closeDriver();
    }
    public static void navigateBack(){
        driver.navigate().back();
    }

    public static void clickOnElement(String element){ //we parameterized the driver
        driver.findElement(By.xpath(element)).click();
    }

    public static void setupDriver(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        //we put the driver in a different method, so we have to make it usable elsewhere
    }
    public static void navigateToUrl(String url){
        driver.get(url); //drivers are initially red

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
    //these are all separated into 4 different methods.



}
