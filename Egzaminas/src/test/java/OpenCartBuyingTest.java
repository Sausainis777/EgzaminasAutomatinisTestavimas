import org.example.CartPage;
import org.example.CheckOutPage;
import org.example.MainPage;
import org.example.ProductPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenCartBuyingTest extends BaseTestPage {
    public int getNumber(String text){

        return Integer.parseInt(text);

    }
    @Test
    void searchTest() {
        MainPage mainPage = new MainPage(driver);


        mainPage.inputSearch("iphone");
        mainPage.clickSearch();

        waiting();

        List<WebElement> titles = driver.findElements(By.cssSelector("h4 > a"));
        for (WebElement title : titles) {
            assertTrue(title.getText().toLowerCase().contains("iphone"));
        }
    }

    @Test
    void addToCart() {
        MainPage mainPage = new MainPage(driver);
        ProductPage productPage = new ProductPage(driver);


        mainPage.inputSearch("Iphone");
        mainPage.clickSearch();

        productPage.clickOnProduct();
        productPage.addToCart();
        waiting();
        productPage.clickOnCart();
        productPage.viewCart();
        waiting();

        assertTrue(driver.findElement(By.linkText("iPhone")).isDisplayed());
    }

    @Test
    void checkOutProduct() {

        MainPage mainPage = new MainPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckOutPage checkOutPage = new CheckOutPage(driver);

        mainPage.inputSearch("Iphone");
        mainPage.clickSearch();

        productPage.clickOnProduct();
        productPage.addToCart();
        waiting();
        productPage.clickOnCart();
        productPage.viewCart();
        waiting();
        cartPage.clickCheckOut();
        waiting();
        checkOutPage.clickGuestRadio();
        checkOutPage.inputFirstName("Tomas");
        checkOutPage.inputLastName("Lomas");
        checkOutPage.inputEmail("lomas@gmail.com");
        checkOutPage.inputAddress("Kauno g.25");
        checkOutPage.inputCity("Vilnius");
        checkOutPage.inputPostCode("LT-2020");
        checkOutPage.selectRegion();
        waiting();
        checkOutPage.hoverToRegion();
        checkOutPage.clickToRegister();
        waiting();
        checkOutPage.selectShippingMethod();
        waiting();
        checkOutPage.selectCar();
        checkOutPage.clickToSelectShippingMethod();
        checkOutPage.choosePayment();
        waiting();
        checkOutPage.selectPayment();
        checkOutPage.clickToSelectPayment();
        waiting();
        checkOutPage.confirmOrder();
        waiting();

        assertEquals("Your order has been placed!", driver.getTitle());


    }

    @ParameterizedTest

    @CsvFileSource(files = "src/main/resources/Search.csv")
    void searchGood(String search) {

        MainPage mainPage = new MainPage(driver);


        mainPage.inputSearch(search);
        mainPage.clickSearch();
        waiting();

        List<WebElement> titles = driver.findElements(By.cssSelector("h4 > a"));
        for (WebElement title : titles) {
            assertTrue(title.getText().toLowerCase().contains(search));

        }
    }

    @Test
    void searchBad() {

        MainPage mainPage = new MainPage(driver);


        mainPage.inputSearch("Snaigė");
        mainPage.clickSearch();
        waiting();
        assertEquals("There is no product that matches the search criteria.", driver.findElement(By.cssSelector("#content p")).getText());

    }

    @Test
    void checkCart() {
        MainPage mainPage = new MainPage(driver);
        ProductPage productPage = new ProductPage(driver);


        mainPage.inputSearch("Iphone");
        mainPage.clickSearch();

        productPage.clickOnProduct();
        productPage.addToCart();
        waiting();
        productPage.clickOnCart();
        productPage.viewCart();
        waiting();
        assertEquals("product 11", driver.findElement(By.cssSelector(".table-responsive tbody tr .text-start:nth-of-type(3)")).getText());
    }
    @Test
    void checkCartPrice(){
        MainPage mainPage = new MainPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);



        mainPage.inputSearch("Iphone");
        mainPage.clickSearch();

        productPage.clickOnProduct();
        productPage.addToCart();
        waiting();
        productPage.clickOnCart();
        productPage.viewCart();
        waiting();
        int subTotal = getNumber(cartPage.subTotal().replace("$", "").replace(".", "").replace(",", ""));
        int ecoTax = getNumber(cartPage.ecoTax().replace("$", "").replace(".", ""));
        int vat = getNumber(cartPage.vat().replace("$", "").replace(".", ""));
        int total = getNumber(cartPage.total().replace("$", "").replace(".", ""));
        int totalSum = subTotal + ecoTax + vat;
        assertEquals(total, totalSum);
    }
    @Test
    void checkCheckOutPageProductInfo(){

        MainPage mainPage = new MainPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);


        mainPage.inputSearch("iPhone");
        mainPage.clickSearch();

        productPage.clickOnProduct();
        productPage.addToCart();
        waiting();
        productPage.clickOnCart();
        productPage.viewCart();
        waiting();
        cartPage.clickCheckOut();
        assertEquals("iPhone",driver.findElement(By.cssSelector(".table.table-bordered a")).getText());
    }
    @Test
    void successfullyOrderInfo(){

        MainPage mainPage = new MainPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckOutPage checkOutPage = new CheckOutPage(driver);

        mainPage.inputSearch("Iphone");
        mainPage.clickSearch();

        productPage.clickOnProduct();
        productPage.addToCart();
        waiting();
        productPage.clickOnCart();
        productPage.viewCart();
        waiting();
        String totalInCart = cartPage.total();
        cartPage.clickCheckOut();
        waiting();
        String totalInCheckOut = driver.findElement(By.xpath("/html//div[@id='checkout-confirm']//table/tfoot/tr[4]/td[2]")).getText();

        assertEquals(totalInCart,totalInCheckOut);

    }

}