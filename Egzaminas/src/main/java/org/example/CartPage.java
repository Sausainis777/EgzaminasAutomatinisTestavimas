package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    By clickCheckOut = By.cssSelector(".col.text-end .btn-primary");
    By subTotal = By.cssSelector("#checkout-total tr:nth-of-type(1) .text-end:nth-of-type(2)");

    By ecoTax = By.cssSelector("tfoot#checkout-total > tr:nth-of-type(2) > td:nth-of-type(2)");
    By vat = By.cssSelector("tfoot#checkout-total > tr:nth-of-type(3) > td:nth-of-type(2)");

    By total = By.xpath("//tfoot[@id='checkout-total']/tr[4]/td[2]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckOut() {
        var element = driver.findElement(clickCheckOut);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

    }

    public String subTotal() {
        return driver.findElement(subTotal).getText();
    }

    public String ecoTax() {
        return driver.findElement(ecoTax).getText();
    }

    public String vat() {
        return driver.findElement(vat).getText();
    }

    public String total() {
        return driver.findElement(total).getText();
    }

}
