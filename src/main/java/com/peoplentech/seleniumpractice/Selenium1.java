package com.peoplentech.seleniumpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    public static void main(String[] args) throws InterruptedException {
        //this allows chrome to be opened and says "Chrome is being controlled by test software"
        //set up data that chrome driver needs
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        //create object from chrome driver
        WebDriver driver = new ChromeDriver();
        //tells chrome to deliver to go to url
        driver.get("https://www.google.com");
        //wait 5 sec then closes chrome
        Thread.sleep(5000);
        driver.close();
    }


}
