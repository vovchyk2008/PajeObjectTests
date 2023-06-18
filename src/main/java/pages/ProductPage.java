package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {

  private final By actualPrice = By.xpath("//div[@id='content']//span[@class='price-new']");

  public double getActualProductPrice() {
    return Double.parseDouble(find(actualPrice).getText().replaceAll("[^\\d.]", ""));
  }


}
