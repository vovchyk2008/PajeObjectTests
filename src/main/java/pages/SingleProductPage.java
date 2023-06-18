package pages;

import blocks.SingleProductBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SingleProductPage extends BasePage {

  private final By singleProductContainer = By.xpath("//div[@id='content']");

  public SingleProductBlock getProductInfo() {
    WebElement container = getDriver().findElement(singleProductContainer);
    return new SingleProductBlock(container);
  }

}
