package pages;

import io.opentelemetry.api.trace.Span;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.swing.text.html.Option;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static helper.Utility.driver;
import static org.bouncycastle.jce.ECGOST3410NamedCurveTable.getNames;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SortItemPage {
    By box_sort_item = By.className("select_container");
    By sortElement1 = By.xpath("//option[@value='za']");
    By sortElement2 = By.xpath("//option[@value='lohi']");
    By sortElement3 = By.xpath("//option[@value='hilo']");
    By item_name = By.className("inventory_item_name");

    By item_price = By.className("inventory_item_price");

    public void clickBoxSortItem(){
        driver.findElement(box_sort_item).click();
    }

    public void sortItemName(){
        driver.findElement(sortElement1).click();
   }

    public void validateSortItemZToA(){
       List<WebElement> productTitles = driver.findElements(item_name);
       for (int i = 0; i < productTitles.size() - 1; i++) {
           String currentTitle = productTitles.get(i).getText();
           String nextTitle = productTitles.get(i + 1).getText();
           assert currentTitle.compareTo(nextTitle) >= 0 : "Items are not sorted correctly";
       }
       System.out.println("Items are sorted correctly from Z to A");
    }

    public void sortItemPriceLoHi(){
        driver.findElement(sortElement2).click();
    }

    public void validateSortItemLoHi(){
        List<WebElement> priceElements = driver.findElements(item_price);
        List<Double> prices = new ArrayList<>();

        for (WebElement priceElement : priceElements) {
            double price = Double.parseDouble(priceElement.getText().replace("$", ""));
            prices.add(price);
        }

        boolean isSorted = isSortedAscending(prices);

        if (isSorted) {
            System.out.println("Products are sorted from low price to high price.");
        } else {
            System.out.println("Products are NOT sorted from low price to high price.");
        }
    }
    private static boolean isSortedAscending(List<Double> list) {
        List<Double> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        return list.equals(sortedList);
    }

    public void sortItemHiLo(){
        driver.findElement(sortElement3).click();
    }

    public void validateSortItemHiLo(){
        List<WebElement> priceElements = driver.findElements(item_price);
        List<Double> prices = new ArrayList<>();

        for (WebElement priceElement : priceElements) {

            double price = Double.parseDouble(priceElement.getText().replace("$", ""));
            prices.add(price);
        }

        boolean isSorted = isSortedDescending(prices);

        if (isSorted) {
            System.out.println("Products are sorted from high price to low price.");
        } else {
            System.out.println("Products are NOT sorted from high price to low price.");
        }
    }
    private static boolean isSortedDescending(List<Double> list) {
        List<Double> sortedList = new ArrayList<>(list);
        sortedList.sort(Collections.reverseOrder());
        return list.equals(sortedList);
    }


}
