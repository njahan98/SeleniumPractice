package com.peoplentech.seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.List;

public class Selenium3 extends TestBase{ //common methods can be pulled from test base
//XPath Rules
    //tagName[text()='___'] => text
    //tagName[@attribute='___'] => id,class,aria-label
    public static void main(String[] args) {
        validateProductDropDown();
        validateUserCanTypeOnSearchBar();
        validateUserCanTypeOnSearchBarAndClickSearchButton();
    }
    public static void validateUserCanTypeOnSearchBar(){
        setupDriver();
        navigateToUrl("https://www.ebay.com/");
        //driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Java Books");
        driver.findElement(By.id("gh-ac")).sendKeys("Java Books");
        sleepFor(2);
        closeDriver();
    }
    public static void validateUserCanTypeOnSearchBarAndClickSearchButton(){
        setupDriver();
        navigateToUrl("https://www.ebay.com/");
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
        sleepFor(2);
        closeDriver();
    }
    public static void validateProductDropDown(){
        setupDriver();
        navigateToUrl("https://www.ebay.com/");
        String data = driver.findElement(By.xpath("//select[@id='gh-cat']")).getText();
        System.out.println(data);
        List<WebElement> dropDown = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
        System.out.println(dropDown.size());
        dropDown.get(5).click();
        sleepFor(2);
        closeDriver();
    }


}
