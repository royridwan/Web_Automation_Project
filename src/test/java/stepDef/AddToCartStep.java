package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AddToCartPage;

public class AddToCartStep {

    AddToCartPage addToCartPage;
    public AddToCartStep() {
        this.addToCartPage = new AddToCartPage();
    }
    @And("user click add to cart button")
    public void userClickAddToCartButton() {
        addToCartPage.clickAddToCart();
    }

    @Then("verify cart item is match {string}")
    public void verifyCartItemIsMatch(String cartItem) {
        addToCartPage.validateCartItem(cartItem);
    }

    @Then("verify cart item is not match {string}")
    public void verifyCartItemIsNotMatch(String cartItem) {
        addToCartPage.negativeCartItem(cartItem);
    }
}
