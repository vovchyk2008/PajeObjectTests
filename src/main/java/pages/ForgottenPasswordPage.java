package pages;

import org.openqa.selenium.By;
import utils.Utils;

public class ForgottenPasswordPage extends BasePage {

  private final By emailInput = By.id("input-email");
  private final By continueButton = By.xpath("//div[@class='float-end']/button");
  private final By alert = By.xpath("//div[@id='alert']/div");


  public ForgottenPasswordPage enterEmail(String email) {
    find(emailInput).sendKeys(email);
    return this;
  }

  public ForgottenPasswordPage clickOnContinueButton() {
    Utils.clickOnElement(getDriver(), find(continueButton));
    return this;
  }

  public String getTextFromAlert() {
    Utils.waitUntilPresents(alert, 10);
    return find(alert).getText();
  }

}