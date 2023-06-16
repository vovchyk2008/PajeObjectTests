package pages;


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BrandsPage extends BasePage {

  private final By brandNames = By.xpath("//div[@class='col-sm-3']/a");

  public List<String> allBrandNames() {
    List<String> brands = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(brandNames);
    for (WebElement br : containers) {
      String name = br.getText();
      brands.add(name);
    }
    return brands;
  }

}
