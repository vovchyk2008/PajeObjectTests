package blocks;

import static pages.BasePage.find;

import enums.MainMenuButtons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CamerasPage;
import pages.DesktopsPage;
import utils.Utils;

public class MainMenuBlock {

  private static WebDriver driver;

  public MainMenuBlock(WebDriver webDriver) {
    driver = webDriver;
  }

  //mainMenu buttons
  protected final By desktopsMainMenuButton = By
      .xpath("//div[@id='narbar-menu']/ul//li/a[contains(text(), 'Desktops')]");
  protected final By camerasMainMenuButton = By
      .xpath("//li/a[text()='Cameras']");

  //subMenu buttons
  protected final By showAllDesktopsSubMenuButton = By
      .xpath("//div[@id='narbar-menu']/ul//li//a[contains(text(), 'Show All Desktops')]");


  public MainMenuBlock hoverToButton(MainMenuButtons buttons) {
    switch (buttons) {
      case DESKTOPS:
        Utils.hoverToButton(desktopsMainMenuButton);
        break;
    }
    return this;
  }

  public DesktopsPage clickOnShowAllDesktopsSubMenuButton() {
    WebElement allDesktopsEl = find(showAllDesktopsSubMenuButton);
    Utils.clickOnElement(driver, allDesktopsEl);
    return new
        DesktopsPage();
  }

  public CamerasPage clickOnCamerasMenuButton() {
    driver.findElement(camerasMainMenuButton).click();
    return new CamerasPage();
  }

}
