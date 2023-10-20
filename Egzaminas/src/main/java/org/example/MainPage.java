package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;
    By inputSearch = By.cssSelector("div#search > input[name='search']");
    By clickSearch = By.xpath("//div[@id='search']//i");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void inputSearch(String search){
        driver.findElement(inputSearch).sendKeys(search);
    }
    public void clickSearch(){
        driver.findElement(clickSearch).click();
    }
}
