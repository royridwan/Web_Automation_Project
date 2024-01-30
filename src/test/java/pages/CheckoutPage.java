package pages;

import org.openqa.selenium.By;

import static helper.Utility.driver;
import static org.junit.Assert.assertTrue;

public class CheckoutPage {
    By cart_logo = By.xpath("//a[@class='shopping_cart_link']");
    By checkout_btn = By.id("checkout");
    By first_name = By.id("first-name");
    By last_name = By.id("last-name");
    By postal_code = By.id("postal-code");
    By continue_btn = By.id("continue");
    By checkout_overview = By.xpath("//span[@class='title']");
    By finish_btn = By.id("finish");
    By order_message = By.xpath("//h2[normalize-space()='Thank you for your order!']");

    public void clickCartLogo(){
        driver.findElement(cart_logo).click();
    }

    public void clickCheckoutBtn(){
        driver.findElement(checkout_btn).click();
    }

    public void inputFirstName(String firstName){
        driver.findElement(first_name).sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        driver.findElement(last_name).sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode){
        driver.findElement(postal_code).sendKeys(postalCode);
    }

    public void clickContinueBtn(){
        driver.findElement(continue_btn).click();
    }

    public void validateOnCheckoutOverview(){
        driver.findElement(checkout_overview);
    }

    public void clickFinishBtn(){
        driver.findElement(finish_btn).click();
    }

    public void checkoutMessage(String orderMessage){
        assertTrue(driver.getPageSource().contains(orderMessage));
    }

    public void errorBtn(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
