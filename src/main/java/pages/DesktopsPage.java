package pages;

import blocks.ProductBlock;
import enums.NumberOfDisplayedProducts;
import enums.SortingBy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

public class DesktopsPage extends BasePage {

  private final By showSelect = By.id("input-limit");
  private final By showSelectElements = By.xpath("//select[@id='input-limit']/option");

  private final By sortingSelect = By.id("input-sort");
  private final By valuesInSortingSelect = By.xpath("//select[@id='input-sort']/option");

  private final By productContainer = By.xpath("//div[@class='product-thumb']");
  private final By textOnTheBottomOfThePage = By.xpath("//div[@class='col-sm-6 text-end']");

  public String getValueFromShowSelect() {
    String showDropdownValue = "";
    List<WebElement> elements = getDriver().findElements(showSelectElements);
    for (WebElement element : elements) {
      if (element.isSelected()) {
        showDropdownValue = element.getText();
      }
    }
    return showDropdownValue;
  }

  public String getValueFromSortSelect() {
    String sortByValue = "";
    List<WebElement> elements = getDriver().findElements(valuesInSortingSelect);
    for (WebElement element : elements) {
      if (element.isSelected()) {
        sortByValue = element.getText();
      }
    }
    return sortByValue;
  }

  public List<ProductBlock> getAllProductsFromPage() {
    List<ProductBlock> products = new ArrayList<>();
    List<WebElement> elements = getDriver().findElements(productContainer);
    for (WebElement element : elements) {
      ProductBlock productBlock = new ProductBlock(element);
      products.add(productBlock);
    }
    return products;
  }

  public DesktopsPage selectSortBy(SortingBy sort) {
    Utils.selectSortBy(sort, find(sortingSelect));
    return this;
  }

  public DesktopsPage selectTheNumberOfShowingElementsOnThePage(NumberOfDisplayedProducts numberOfProducts) {
    Utils.selectTheNumberOfShowingElementsOnThePage(numberOfProducts, find(showSelect));
   return this;
  }

  public String getTextOnTheBottomOfThePage() {
    return find(textOnTheBottomOfThePage).getText();
  }

  public List<ProductBlock> getSortedProductsFromAToZ(
      List<ProductBlock> getAllProductsFromAllProductsPage) {
    List<ProductBlock> products = new ArrayList<>(getAllProductsFromAllProductsPage);
    products.sort(new Comparator<ProductBlock>() {
      @Override
      public int compare(ProductBlock o1, ProductBlock o2) {
        return o1.getNameAsString().compareToIgnoreCase(o2.getNameAsString());
      }
    });
    return products;
  }

  public List<ProductBlock> getSortedProductsByPriceFromLowToHigh(List<ProductBlock> getAllProductsFromAllProductsPage) {
    List<ProductBlock> products = new ArrayList<>(getAllProductsFromAllProductsPage);

    products.sort(new Comparator<ProductBlock>() {
      @Override
      public int compare(ProductBlock o1, ProductBlock o2) {
        return o1.getActualPriceAsDouble().compareTo(o2.getActualPriceAsDouble());
      }
    });
    return products;
  }


}