package pages;

import blocks.ProductsBlock;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.By;
import utils.Utils;

@Getter
public class MainPage extends BasePage {

  private static final By productContainer = By.xpath("//div[@class='product-thumb']");

  public List<ProductsBlock> getAllProductsFromPage() {
    return Utils.getAllProductsFromPage(productContainer);
  }

  public SingleProductPage clickOnProductByName(String name) {
    Utils.clickOnProductByName(productContainer, name);
    return new SingleProductPage();
  }

}
