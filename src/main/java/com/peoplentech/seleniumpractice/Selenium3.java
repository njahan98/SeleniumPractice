package com.peoplentech.seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium3 extends TestBase {

    @Test
    public static void validateUserCanTypeOnSearchBar() {
        setupDriver("chrome");
        navigateToURL("https://www.ebay.com");

        driver.findElement(By.id("gh-ac")).sendKeys("Java Books");
        // driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Java Books");

        sleepFor(2);
        closeDriver();
    }

    @Test
    public static void validateUserCanTypeOnSearchBarAndClickSearchButton() {
        setupDriver("chrome");
        navigateToURL("https://www.ebay.com");

        driver.findElement(By.id("gh-ac")).sendKeys("Java Books");
        // driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Java Books");

        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();

        sleepFor(2);
        closeDriver();
    }


    @Test
    public static void validateProductDropDown() {
        setupDriver("chrome");
        navigateToURL("https://www.ebay.com");

        // print the data directly
        String data = driver.findElement(By.xpath("//select[@id='gh-cat']")).getText();
        System.out.println(data);

        //get all the element in the list
        List<WebElement> dropDown = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
        System.out.println(dropDown.size());

        dropDown.get(5).click();


        sleepFor(5);
        closeDriver();
    }

    @Test
    public static void validateUserCanTypeOnSearchBarAndChooseFromDropDown() {
        setupDriver("chrome");
        navigateToURL("https://www.ebay.com");


        driver.findElement(By.id("gh-ac")).sendKeys("Java Books");
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
        sleepFor(2);


        WebElement searchedItem = driver.findElement(By.xpath("//span[text()='Java Books']"));
        String actualText = searchedItem.getText();
        System.out.println(actualText);

        Assert.assertEquals(actualText, "Java Books");


        boolean validation = searchedItem.isDisplayed();
        System.out.println(validation);

        closeDriver();
    }


    @Test
    public static void seleniumMethods() {
        setupDriver("chrome");
        navigateToURL("https://www.ebay.com");

        WebElement clickElement = driver.findElement(By.xpath("//input[@id='gh-btn']"));
        clickElement.click();
        sleepFor(2);

        driver.findElement(By.xpath("//h2[text()='eBay Motors']")).click();
        sleepFor(2);

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        Assert.assertTrue(currentUrl.contains("Auto-Parts-and-Vehicles"));

        //first one is actual, second one is expected
        Assert.assertEquals(currentUrl, "https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334");

        sleepFor(5);
        closeDriver();
    }


}