package com.peoplentech.seleniumpractice;

public class Selenium3 extends TestBase{ //common methods can be pulled from test base

    public static void main(String[] args) {

    }
    public static void validateUserCanTypeOnSearchBar(){
        setupDriver();
        navigateToUrl("https://www.ebay.com/");

        sleepFor(2);
        closeDriver();
    }

}
