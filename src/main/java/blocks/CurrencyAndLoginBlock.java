package blocks;

import static pages.BasePage.find;

import enums.Currency;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

@Data
public class CurrencyAndLoginBlock {

  private static WebDriver driver;


  public CurrencyAndLoginBlock(WebDriver webDriver) {
    driver = webDriver;
  }

  //login block
  private final By myAccountButton = By
      .xpath(" //div[@class='nav float-end']//span[contains(text(), 'My Account')]");
  private final By loginButton = By.xpath(
      " //ul[@class='dropdown-menu dropdown-menu-right show']//a[contains(text(), 'Login')]");

  //currency block
  protected final By currencyButton = By.xpath("//form[@id='form-currency']");
  protected final By dollar = By.xpath("//a[@href='USD']");
  protected final By euro = By.xpath("//a[@href='EUR']");
  protected final By sterling = By.xpath("//a[@href='GBP']");
  protected final By currencyMark = By.xpath("//strong");


  public CurrencyAndLoginBlock clickOnMyAccountButton() {
    find(myAccountButton).click();
    return this;
  }

  public LoginPage clickOnLoginButton() {
    find(loginButton).click();
    return new LoginPage();
  }

  public String getCurrentCurrency() {
    return driver.findElement(currencyMark).getText();
  }

  public void selectCurrency(Currency currency) {
    switch (currency) {
      case $:
        driver.findElement(currencyButton).click();
        driver.findElement(dollar).click();
        break;
      case €:
        driver.findElement(currencyButton).click();
        driver.findElement(euro).click();
        break;
      case £:
        driver.findElement(currencyButton).click();
        driver.findElement(sterling).click();
    }
  }

}