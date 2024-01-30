package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static helper.Utility.driver;
import static org.junit.Assert.assertTrue;

public class LoginPage {

    By input_username = By.id("user-name");
    By input_pwd = By.id("password");
    By btn_login = By.name("login-button");
    By home_page = By.xpath("//span[@class='title']");

    public void goToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUsername(String username) {
        driver.findElement(input_username).sendKeys(username);
    }

    public void inputPwd(String pwd) {
        driver.findElement(input_pwd).sendKeys(pwd);
    }

    public void clickBtnLogin(){
        driver.findElement(btn_login).click();
    }

    public void validateOnHomePage(){
        driver.findElement(home_page);
    }

    public void validateErrorAppear(String errorMessage){
        assertTrue(driver.getPageSource().contains(errorMessage));
    }

}
