package pages;

import blocks.FooterBlock;
import blocks.MainMenuBlock;
import blocks.CurrencyAndLoginBlock;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

@Data
public abstract class BasePage {

  private static WebDriver driver;

  public static WebDriver getDriver() {
    return driver;
  }

  public static void setDriver(WebDriver webDriver) {
    driver = webDriver;
  }


//Utils utils = new Utils(getDriver());

  FooterBlock footerBlock = new FooterBlock(getDriver());
  CurrencyAndLoginBlock currencyAndLoginBlock = new CurrencyAndLoginBlock(getDriver());
  MainMenuBlock mainMenuBlock = new MainMenuBlock(getDriver());

  public static WebElement find(By locator) {
    return driver.findElement(locator);
  }
}
