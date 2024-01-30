package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;

public class CheckoutStep {

    CheckoutPage checkoutPage;

    public CheckoutStep(){
        this.checkoutPage = new CheckoutPage();
    }
    @And("user click cart logo")
    public void userClickCartLogo() {
        checkoutPage.clickCartLogo();
    }

    @And("user click checkout button")
    public void userClickCheckoutButton() {
        checkoutPage.clickCheckoutBtn();
    }

    @And("user input first name {string}")
    public void userInputFirstName(String firstName) {
        checkoutPage.inputFirstName(firstName);
    }

    @And("user input last name {string}")
    public void userInputLastName(String lastName) {
        checkoutPage.inputLastName(lastName);
    }

    @And("user input postal code {string}")
    public void userInputPostalCode(String postalCode) {
        checkoutPage.inputPostalCode(postalCode);
    }

    @And("user click continue button")
    public void userClickContinueButton() {
        checkoutPage.clickContinueBtn();
    }

    @And("user go to checkout overview")
    public void userGoToCheckoutOverview() {
        checkoutPage.validateOnCheckoutOverview();
    }

    @When("user click finish button")
    public void userClickFinishButton() {
        checkoutPage.clickFinishBtn();
    }

    @Then("user get message {string}")
    public void userGetMessage(String errorMessage) {
        checkoutPage.checkoutMessage(errorMessage);
    }

    @Then("user cant finish checkout")
    public void userCantFinishCheckout() {
        checkoutPage.errorBtn();
    }
}
