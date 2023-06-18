package pages;

import blocks.ProductsBlock;
import java.util.List;
import org.openqa.selenium.By;
import utils.Utils;

public class CamerasPage extends BasePage {

  private final By productContainer = By.xpath("//div[@class='product-thumb']");


  public List<ProductsBlock> getAllProductsFromCamerasPage() {
    return Utils.getAllProductsFromPage(productContainer);
  }

  public ProductsBlock getProductByName(List<ProductsBlock> products, String productName) {
    for (ProductsBlock product : products) {
      if (product.getNameAsString().equals(productName)) {
        return product;
      }
    }
    throw new IllegalArgumentException("Cannot find product with name: " + productName);
  }

}
