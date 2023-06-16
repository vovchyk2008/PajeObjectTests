package pages;

import blocks.ProductBlock;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

@Getter
public class MainPage extends BasePage {

  private static final By productContainer = By.xpath("//div[@class='product-thumb']");


  public List<ProductBlock> getAllProductsFromPage() {
    return Utils.getAllProductsFromPage(productContainer);
  }

  public ProductPage clickOnProductByName(String name) {
    Utils.clickOnProductByName(productContainer, name);
return new ProductPage();
  }

}
