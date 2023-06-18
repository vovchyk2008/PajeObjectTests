import blocks.ProductBlock;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.CamerasPage;
import pages.MainPage;

public class Test5 extends BaseTest {

  @Test
  public void checkCamerasPageTest() {

    String canonProductName = "Canon EOS 5D";
    String nikonProductName = "Nikon D300";
    double expectedOldPriceOfCanonProduct = 122.00;
    double expectedNewPriceOfCanonProduct = 98.00;
    double expectedExRateOfNikonProduct = 80.00;
    int expectedNumberOfProductsOnThePage = 2;

    MainPage mainPage = new MainPage();
    List<ProductBlock> allProductsFromPage = mainPage
        .getMainMenuBlock()
        .clickOnCamerasMenuButton()
        .getAllProductsFromCamerasPage();

    SoftAssertions softAssertions = new SoftAssertions();

    //Check that 2 cameras exist on page
    softAssertions.assertThat(allProductsFromPage)
        .as("We are waiting that " + expectedNumberOfProductsOnThePage + " products exist on page")
        .hasSize(expectedNumberOfProductsOnThePage);

    CamerasPage camerasPage = new CamerasPage();
    ProductBlock canonProduct = camerasPage
        .getProductByName(allProductsFromPage, canonProductName);
    ProductBlock nikonProduct = camerasPage
        .getProductByName(allProductsFromPage, nikonProductName);

    //Check that Canon EOS 5D has old price 122.00
    softAssertions.assertThat(canonProduct.getOldPriceAsDouble())
        .as("We are waiting that Canon EOS 5D has old price has old price "
            + expectedOldPriceOfCanonProduct)
        .isEqualTo(expectedOldPriceOfCanonProduct);

    //Check that Canon EOS 5D has new price 98.00
    softAssertions.assertThat(canonProduct.getActualPriceAsDouble())
        .as("We are waiting that Canon EOS 5D has old price has new price "
            + expectedNewPriceOfCanonProduct)
        .isEqualTo(expectedNewPriceOfCanonProduct);

    //Check that Nikon D300 has ex.rate 80.00
    softAssertions.assertThat(nikonProduct.getExTaxAsDouble())
        .as("We are waiting that Nikon D300 has ex.rate" + expectedExRateOfNikonProduct)
        .isEqualTo(expectedExRateOfNikonProduct);

    softAssertions.assertAll();

  }
}