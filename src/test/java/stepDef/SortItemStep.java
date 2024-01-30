package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SortItemPage;

public class SortItemStep {

    SortItemPage sortItemPage;
    public SortItemStep() {
        this.sortItemPage = new SortItemPage();
    }
    @And("user click combo box sort item")
    public void userClickComboBoxSortItem() {
        sortItemPage.clickBoxSortItem();
    }

    @When("user click sort by name Z to A")
    public void userClickSortByNameZToA() {
        sortItemPage.sortItemName();
    }

    @Then("item list appear item sort from Z to A")
    public void itemListAppearItemSortFromZToA() {
        sortItemPage.validateSortItemZToA();
    }

    @When("user click sort by price low to high")
    public void userClickSortByPriceLowToHigh() {
        sortItemPage.sortItemPriceLoHi();
    }

    @Then("item list appear item sort price low to high")
    public void itemListAppearItemSortPriceLowToHigh() {
        sortItemPage.validateSortItemLoHi();
    }

    @When("user click sort by price high to low")
    public void userClickSortByPriceHighToLow() {
        sortItemPage.sortItemHiLo();
    }

    @Then("item list appear item sort price high to low")
    public void itemListAppearItemSortPriceHighToLow() {
        sortItemPage.validateSortItemHiLo();
    }

}
