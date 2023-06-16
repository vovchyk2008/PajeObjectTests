package pages;

import org.openqa.selenium.By;
import utils.Utils;

public class LoginPage extends BasePage{

  private final By forgetPasswordButton = By.xpath("//div[@class='mb-3']/a[contains(text(),'Forgotten Password')]");

  public ForgottenPasswordPage clickOnForgetPasswordButton(){
    Utils.clickOnElement(getDriver(), find(forgetPasswordButton));
    return new ForgottenPasswordPage();
  }

}
