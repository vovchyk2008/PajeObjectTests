import static enums.Currency.$;
import static enums.Currency.£;
import static enums.Currency.€;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SingleProductPage;

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

    Double actualProductPriceInDollars = mainPage
        .clickOnProductByName(productName)
        .getProductInfo()
        .getActualPriceAsDouble();

    //Check product price in Dollars
    softAssertions.assertThat(actualProductPriceInDollars)
        .as("Product price in Dollars must be " + expectedIphonePriceInDollars)
        .isEqualTo(expectedIphonePriceInDollars);

    SingleProductPage singleProductPage = new SingleProductPage();
    singleProductPage
        .getCurrencyAndLoginBlock()
        .selectCurrency(€);

    double actualProductPriceInEuros = singleProductPage
        .getProductInfo()
        .getActualPriceAsDouble();

    //Check product price in Euros
    softAssertions.assertThat(actualProductPriceInEuros)
        .as("Product price in Euros must be " + expectedIphonePriceInEuros)
        .isEqualTo(expectedIphonePriceInEuros);

    singleProductPage
        .getCurrencyAndLoginBlock()
        .selectCurrency(£);

    double actualProductPriceInPounds = singleProductPage
        .getProductInfo()
        .getActualPriceAsDouble();

    //Check product price in Pound Sterling
    softAssertions.assertThat(actualProductPriceInPounds)
        .as("Product price in Pound Sterling must be " + expectedIphonePriceInPoundSterling)
        .isEqualTo(expectedIphonePriceInPoundSterling);

    softAssertions.assertAll();
  }
}
