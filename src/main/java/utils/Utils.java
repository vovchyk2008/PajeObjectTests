package utils;

import static pages.BasePage.getDriver;

import blocks.ProductsBlock;
import enums.NumberOfDisplayedProducts;
import enums.SortingBy;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@Data
public class Utils {

  private static WebDriver driver;
  private static Actions actions;

  public static void setDriver(WebDriver webdriver) {
    driver = webdriver;
    actions = new Actions(driver);
  }

  public static void scrollToElement(WebDriver driver, WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  }

  public static void clickOnElement(WebDriver driver, WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
  }

  public static void hoverToButton(By button) {
    waitUntilPresents(button, 10);
    actions.moveToElement(driver.findElement(button)).build().perform();
  }

  public static WebElement waitUntilPresents(By locator, int second) {
    return new WebDriverWait(driver, Duration.ofSeconds(second))
        .until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  public static List<ProductsBlock> getAllProductsFromPage(By container) {
    List<ProductsBlock> products = new ArrayList<>();
    List<WebElement> elements = getDriver().findElements(container);
    for (WebElement element : elements) {
      ProductsBlock productsBlock = new ProductsBlock(element);
      products.add(productsBlock);
    }
    return products;
  }

  public static void selectTheNumberOfShowingElementsOnThePage(
      NumberOfDisplayedProducts numberOfProducts, WebElement selectContainer) {
    Select select = new Select(selectContainer);
    switch (numberOfProducts) {
      case SHOW_10:
        select.selectByVisibleText("10");
        break;
      case SHOW_25:
        select.selectByVisibleText("25");
        break;
      case SHOW_50:
        select.selectByVisibleText("50");
      case SHOW_75:
        select.selectByVisibleText("75");
      case SHOW_100:
        select.selectByVisibleText("100");
        break;
    }
  }

  public static void selectSortBy(SortingBy sort, WebElement selectContainer) {
    Select select = new Select(selectContainer);
    switch (sort) {
      case DEFAULT:
        select.selectByVisibleText("Default");
        break;
      case NAME_A_TO_Z:
        select.selectByVisibleText("Name (A - Z)");
        break;
      case NAME_Z_TO_A:
        select.selectByVisibleText("Name (Z - A)");
        break;
      case PRICE_LOW_TO_HIGH:
        select.selectByVisibleText("Price (Low > High)");
        break;
      case PRICE_HIGH_TO_LOW:
        select.selectByVisibleText("Price (High > Low)");
        break;
    }
  }

  public static void clickOnProductByName(By container, String name) {
    List<ProductsBlock> products = new ArrayList<>();
    List<WebElement> elements = getDriver().findElements(container);
    for (WebElement element : elements) {
      ProductsBlock productsBlock = new ProductsBlock(element);
      products.add(productsBlock);
    }
    for (ProductsBlock product : products) {
      if (product.getNameAsString().equals(name)) {
        product.getImg().click();
      }
    }
  }

}