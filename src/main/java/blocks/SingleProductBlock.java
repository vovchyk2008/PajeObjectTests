package blocks;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class SingleProductBlock {

  private WebElement nameAsWebElement;
  private String nameAsString;
  private String actualPrice;
  private Double actualPriceAsDouble;
  private String oldPrice;
  private Double oldPriceAsDouble;

  //div[@id='content']
  public SingleProductBlock(WebElement container) {
    try {
      this.nameAsWebElement = container.findElement(By.xpath(".//div[@class='col-sm']/h1"));
      this.nameAsString = nameAsWebElement.getText();
    } catch (NoSuchElementException e) {
      this.nameAsWebElement = null;
      this.nameAsString = null;
    }

    try {
      this.actualPrice = container.findElement(By.xpath(".//span[@class='price-new']")).getText();
      this.actualPriceAsDouble = Double
          .parseDouble(actualPrice.replaceAll("[^\\d.]", ""));
    } catch (NoSuchElementException e) {
      this.actualPrice = null;
      this.actualPriceAsDouble = null;
    }

    try {
      this.oldPrice = container.findElement(By.xpath(".//li[contains(text(),'Ex Tax')]")).getText();
      this.oldPriceAsDouble = Double
          .parseDouble(oldPrice.replaceAll("[^\\d.]", ""));
    } catch (NoSuchElementException e) {
      this.oldPrice = null;
      this.oldPriceAsDouble = null;
    }
  }
}

