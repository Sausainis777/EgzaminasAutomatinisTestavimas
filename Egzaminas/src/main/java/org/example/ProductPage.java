package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;
    By clickOnProduct = By.cssSelector(".col.mb-3 img[alt='iPhone']");
    By addToCart = By.id("button-cart");

    By clickOnCart = By.xpath("//div[@id='header-cart']//button[@type='button']");

    By viewCart = By.cssSelector("p > a:nth-of-type(1) > strong");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnProduct(){
        driver.findElement(clickOnProduct).click();
    }
    public void addToCart(){
        var element = driver.findElement(addToCart);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void clickOnCart(){
        var element = driver.findElement(clickOnCart);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void viewCart(){
        var element = driver.findElement(viewCart);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);


    }
}
