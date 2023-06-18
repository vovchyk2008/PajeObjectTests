package blocks;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class ProductsBlock {

  private WebElement img;
  private WebElement nameAsWebElement;
  private String nameAsString;
  private WebElement descriptionAsWebElement;
  private String description;
  private String actualPrice;
  private Double actualPriceAsDouble;
  private String oldPrice;
  private Double oldPriceAsDouble;
  private String exTax;
  private Double exTaxAsDouble;
  private WebElement addToCart;
  private WebElement addToWishList;
  private WebElement compareThisProduct;


  //container //div[@id='product-list']//div[@class='col']
  public ProductsBlock(WebElement container) {
    try {
      this.img = container.findElement(By.xpath(".//div[@class='image']"));
    } catch (NoSuchElementException e) {
      this.img = null;
    }

    try {
      this.nameAsWebElement = container.findElement(By.xpath(".//div[@class='description']//a"));
      this.nameAsString = nameAsWebElement.getText();
    } catch (NoSuchElementException e) {
      this.nameAsWebElement = null;
      this.nameAsString = null;
    }

    try {
      this.descriptionAsWebElement = container
          .findElement(By.xpath(".//div[@class='description']/p"));
      this.description = descriptionAsWebElement.getText();
    } catch (NoSuchElementException e) {
      this.descriptionAsWebElement = null;
      this.description = null;
    }

    try {
      this.actualPrice = container.findElement(By.xpath(".//span[@class='price-new']")).getText();
      this.actualPriceAsDouble = Double
          .parseDouble(StringUtils.substring(actualPrice, 1).replace(",", ""));
    } catch (NoSuchElementException e) {
      this.actualPrice = null;
      this.actualPriceAsDouble = null;
    }

    try {
      this.oldPrice = container.findElement(By.xpath(".//span[@class='price-old']")).getText();
      this.oldPriceAsDouble = Double
          .parseDouble(StringUtils.substringAfter(oldPrice, "$").replace(",", ""));
    } catch (NoSuchElementException e) {
      this.oldPrice = null;
      this.oldPriceAsDouble = null;
    }

    try {
      this.exTax = container.findElement(By.xpath(".//span[@class='price-tax']")).getText();
      this.exTaxAsDouble = Double
          .parseDouble(StringUtils.substringAfter(exTax, "$").replace(",", ""));
    } catch (NoSuchElementException e) {
      this.exTax = null;
      this.exTaxAsDouble = null;
    }

    try {
      this.addToCart = container.findElement(By.xpath(".//button[@aria-label='Add to Cart']"));
    } catch (NoSuchElementException e) {
      this.img = null;
    }

    try {
      this.addToWishList = container
          .findElement(By.xpath(".//button[@aria-label='Add to Wish List']"));
    } catch (NoSuchElementException e) {
      this.img = null;
    }

    try {
      this.compareThisProduct = container
          .findElement(By.xpath(".//button[@aria-label='Compare this Product']"));
    } catch (NoSuchElementException e) {
      this.img = null;
    }
  }
}
