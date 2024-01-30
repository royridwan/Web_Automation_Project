package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

import static helper.Utility.driver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddToCartPage {
    By addToCart_btn = By.xpath("(//*[text()='Add to cart'])[1]");
    By cart_icon = By.xpath("//span[@class='shopping_cart_badge']");


    public void clickAddToCart(){
        driver.findElement(addToCart_btn).click();
    }

    public void validateCartItem(String cartItem){
        String itemExpected = cartItem;
        String itemActual = driver.findElement(cart_icon).getText();
        Assertions.assertThat(itemActual).isEqualTo(itemExpected);
    }

    public void negativeCartItem(String cartItem){
        cartItem = driver.findElement(cart_icon).getText();
        Assertions.assertThat(cartItem);
    }
}
