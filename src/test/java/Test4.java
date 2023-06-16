import static enums.Currency.$;
import static enums.Currency.£;
import static enums.Currency.€;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProductPage;

public class Test4 extends BaseTest {

  @Test
  public void checkCurrencyTest() {

    double expectedIphonePriceInDollars = 123.20;
    double expectedIphonePriceInEuros = 106.04;
    double expectedIphonePriceInPoundSterling = 95.32;
    String dollarIcon = "$";
    String productName = "iPhone";

    MainPage mainPage = new MainPage();
    String currentCurrency = mainPage
        .getCurrencyAndLoginBlock()
        .getCurrentCurrency();

    SoftAssertions softAssertions = new SoftAssertions();

    //Check that current currency is $
    softAssertions.assertThat(currentCurrency)
        .as("")
        .isEqualTo(dollarIcon);

    mainPage
        .getCurrencyAndLoginBlock()
        .selectCurrency($);

    double actualProductPriceInDollars = mainPage
        .clickOnProductByName(productName)
        .getActualProductPrice();

    //Check product price in Dollars
    softAssertions.assertThat(actualProductPriceInDollars)
        .as("Product price in Dollars must be " + expectedIphonePriceInDollars)
        .isEqualTo(expectedIphonePriceInDollars);

    ProductPage productPage = new ProductPage();
    productPage
        .getCurrencyAndLoginBlock()
        .selectCurrency(€);

    double actualProductPriceInEuros = productPage.getActualProductPrice();

    //Check product price in Euros
    softAssertions.assertThat(actualProductPriceInEuros)
        .as("Product price in Euros must be " + expectedIphonePriceInEuros)
        .isEqualTo(expectedIphonePriceInEuros);

    productPage
        .getCurrencyAndLoginBlock()
        .selectCurrency(£);

    double actualProductPriceInPounds = productPage
        .getActualProductPrice();

    //Check product price in Pound Sterling
    softAssertions.assertThat(actualProductPriceInPounds)
        .as("Product price in Pound Sterling must be " + expectedIphonePriceInPoundSterling)
        .isEqualTo(expectedIphonePriceInPoundSterling);

    softAssertions.assertAll();
  }
}
//Go to the https://demo.opencart.com/
//On the main page check that current currency is $ (change to $ id not)
//Click on the Iphone
//Check that price 123.20
//Change currency to euro
//Check that price 106.04
//Change currency to Pound Sterling
//Check that price 95.32