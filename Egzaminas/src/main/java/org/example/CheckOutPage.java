package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;

public class CheckOutPage {
    WebDriver driver;
    By clickGuestRadio = By.xpath("/html//input[@id='input-guest']");
    By inputFirstName = By.id("input-firstname");
    By inputLastName = By.id("input-lastname");
    By inputEmail = By.id("input-email");
    By inputAddress = By.cssSelector("input[name='shipping_address_1']");
    By inputCity = By.id("input-shipping-city");
    By inputPostCode = By.id("input-shipping-postcode");
    By selectRegion = By.id("input-shipping-zone");
    By hoverToRegion = By.xpath("//select[@id='input-shipping-zone']/option[@value='3518']");
    By clickToRegister = By.id("button-register");
    By selectShippingMethod = By.xpath("/html//button[@id='button-shipping-methods']");
    By selectCar = By.xpath("/html//input[@id='input-shipping-method-flat-flat']");
    By clickToSelectShippingMethod = By.id("button-shipping-method");
    By choosePayment = By.id("button-payment-methods");
    By selectPayment = By.id("input-payment-method-cod-cod");
    By clickToSelectPayment = By.id("button-payment-method");
    By confirmOrder = By.id("button-confirm");
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickGuestRadio(){
        var element = driver.findElement(clickGuestRadio);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void inputFirstName(String firstName){
        driver.findElement(inputFirstName).sendKeys(firstName);
    }
    public void inputLastName(String lastName){
        driver.findElement(inputLastName).sendKeys(lastName);
    }
    public void inputEmail(String email){
        driver.findElement(inputEmail).sendKeys(email);
    }
    public void inputAddress(String address){
        driver.findElement(inputAddress).sendKeys(address);
    }
    public void inputCity(String city){
        driver.findElement(inputCity).sendKeys(city);
    }
    public void inputPostCode(String postCode){
        driver.findElement(inputPostCode).sendKeys(postCode);
    }
    public void selectRegion(){
        var element = driver.findElement(selectRegion);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

    }
    public void hoverToRegion(){
        driver.findElement(hoverToRegion).click();
    }
    public void selectShippingMethod(){
        var element = driver.findElement(selectShippingMethod);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void selectCar(){
        var element = driver.findElement(selectCar);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void clickToRegister(){
        var element = driver.findElement(clickToRegister);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void choosePayment(){
        var element = driver.findElement(choosePayment);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void selectPayment(){
        var element = driver.findElement(selectPayment);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void clickToSelectShippingMethod(){
        var element = driver.findElement(clickToSelectShippingMethod);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void clickToSelectPayment(){
        var element = driver.findElement(clickToSelectPayment);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void confirmOrder(){
        var element = driver.findElement(confirmOrder);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
