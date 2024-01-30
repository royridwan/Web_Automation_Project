package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginStep {
    LoginPage loginPage;

    public LoginStep() {
        this.loginPage = new LoginPage();
    }

    @Given("user go to login page")
    public void userGoToLoginPage() {
        loginPage.goToLoginPage();
    }

    @And("user input username {string}")
    public void userInputUsername(String username) {
        loginPage.inputUsername(username);
    }

    @And("user input pwd {string}")
    public void userInputPwd(String pwd) {
        loginPage.inputPwd(pwd);
    }

    @When("user click button login")
    public void userClickButtonLogin() {
        loginPage.clickBtnLogin();
    }

    @Then("user go to home page")
    public void userGoToHomePage() {
        loginPage.validateOnHomePage();
    }

    @Then("user able to see error message {string}")
    public void userAbleToSeeErrorMessage(String errorMessage) {
        loginPage.validateErrorAppear(errorMessage);
    }

}
