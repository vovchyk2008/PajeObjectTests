package pages;

import blocks.ProductBlock;
import java.util.List;
import org.openqa.selenium.By;
import utils.Utils;

public class CamerasPage extends BasePage {

  private final By productContainer = By.xpath("//div[@class='product-thumb']");


  public List<ProductBlock> getAllProductsFromCamerasPage() {
    return Utils.getAllProductsFromPage(productContainer);
  }

  public ProductBlock getProductByName(List<ProductBlock> products, String productName) {
    for (ProductBlock product : products) {
      if (product.getNameAsString().equals(productName)) {
        return product;
      }
    }
    throw new IllegalArgumentException("Cannot find product with name: " + productName);
  }

}
