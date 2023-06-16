import static enums.MainMenuButtons.DESKTOPS;
import static enums.SortingBy.NAME_A_TO_Z;
import static enums.SortingBy.PRICE_LOW_TO_HIGH;

import blocks.ProductBlock;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.DesktopsPage;
import pages.MainPage;

public class Test3 extends BaseTest {

  @Test
  public void checkThatSortingIsCorrectTest() {
    MainPage mainPage = new MainPage();
    List<ProductBlock> allProductsFromPageAfterSortingFromAToZ = mainPage
        .getMainMenuBlock()
        .hoverToButton(DESKTOPS)
        .clickOnShowAllDesktopsSubMenuButton()
        .selectSortBy(NAME_A_TO_Z)
        .getAllProductsFromPage();

    DesktopsPage desktopsPage = new DesktopsPage();
    List<ProductBlock> sortedProductsFromAToZ = desktopsPage
        .getSortedProductsFromAToZ(allProductsFromPageAfterSortingFromAToZ);

    //Check that products were sorted By 'Name (A - Z)' correctly
    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(allProductsFromPageAfterSortingFromAToZ)
        .as("We are waiting that sorting must be correct")
        .isEqualTo(sortedProductsFromAToZ);

    List<ProductBlock> allProductsFromPageAfterSortingByPriceFromLowToHigh = desktopsPage
        .selectSortBy(PRICE_LOW_TO_HIGH)
        .getAllProductsFromPage();

    List<ProductBlock> sortedProductsByPriceFromLowToHigh = desktopsPage
        .getSortedProductsByPriceFromLowToHigh(allProductsFromPageAfterSortingByPriceFromLowToHigh);

    //Check that products were sorted By 'Price (Low > High)' correctly
    softAssertions.assertThat(allProductsFromPageAfterSortingByPriceFromLowToHigh)
        .as("We are waiting that sorting must be correct")
        .isEqualTo(sortedProductsByPriceFromLowToHigh);

    softAssertions.assertAll();
  }
}
