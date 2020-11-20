package com.peoplentech.seleniumpractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Selenium4 extends TestBase {

    @Test //goal is to have one element go to another place
    public void validateDragAndDrop(){
        setupDriver("chrome");
        navigateToURL("http://demo.guru99.com/test/drag_drop.html");
        sleepFor(2);

        WebElement source = driver.findElement(By.xpath("(//li[@data-id=\"2\"])[1]"));
        WebElement destination = driver.findElement(By.xpath("//ol[@id=\"amt8\"]"));

        Actions actions = new Actions(driver); //you send driver here to parameterize constructor
        actions.dragAndDrop(source,destination).build().perform();

        sleepFor(5);
        closeDriver();
    }
    @Test(enabled = false)
    public void validateiFrame(){ //iframes are pages within pages
        setupDriver("chrome");
        navigateToURL("https://demoqa.com/frames");
        sleepFor(2);

        //frame ID, frame name, frame index
        driver.switchTo().frame("frame1");
        //perform all required actions in the child page
        driver.findElement(By.xpath("xpath from child page")).click();

        driver.switchTo().defaultContent();
        //perform all actions required in the parent page
        driver.findElement(By.xpath("xpath from main page")).click();

        sleepFor(5);
        closeDriver();
    }
    @Test
    public void validateDropDown(){
        setupDriver("chrome");
        navigateToURL("https://ebay.com");
        sleepFor(2);

        WebElement element = driver.findElement(By.id("gh-cat"));
        Select select = new Select(element);
        select.selectByVisibleText("Music");

        sleepFor(5);
        closeDriver();
    }
    @Test
    public void validateMouseHover(){
        setupDriver("chrome");
        navigateToURL("https://ebay.com");
        sleepFor(2);

        WebElement motors = driver.findElement(By.linkText("Motors"));
        Actions actions = new Actions(driver);
        actions.moveToElement(motors).build().perform();
        sleepFor(2);
        driver.findElement(By.linkText("Cars & Trucks")).click();

        sleepFor(5);
        closeDriver();
    }
}
