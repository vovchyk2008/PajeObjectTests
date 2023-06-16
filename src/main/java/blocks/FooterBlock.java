package blocks;


import static pages.BasePage.find;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BrandsPage;
import utils.Utils;

@Data
public class FooterBlock {

  protected static WebDriver driver;

  public FooterBlock(WebDriver webDriver) {
    driver = webDriver;
  }

  private final By brandsButton = By.xpath("//li/a[contains(text(),'Brands')]");

  public BrandsPage clickOnBrandsButton() {
    WebElement el = find(brandsButton);
    Utils.scrollToElement(driver, el);
    Utils.clickOnElement(driver, el);
    return new BrandsPage();
  }

}
