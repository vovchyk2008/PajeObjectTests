import static enums.MainMenuButtons.DESKTOPS;
import static enums.NumberOfDisplayedProducts.SHOW_25;

import blocks.ProductBlock;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.DesktopsPage;
import pages.MainPage;

public class Test2 extends BaseTest {

  String expectedValueInShowDropdown = "10";
  String expectedValueInSortDropdown = "Default";
  int expectedNumberOfProductsOnPage = 10;
  int expectedNumberOfProductsOnPageAfterSelection = 12;
  String expectedTextOnTheBottomOfThePage = "Showing 1 to 12 of 12 (1 Pages)";

  @Test
  public void checkSelectsTest() {
    MainPage mainPage = new MainPage();
    String actualValueInShowDropdown = mainPage
        .getMainMenuBlock()
        .hoverToButton(DESKTOPS)
        .clickOnShowAllDesktopsSubMenuButton()
        .getValueFromShowSelect();

    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(actualValueInShowDropdown)
        .as("We are waiting for the next value from the ShowDropdown" + expectedValueInShowDropdown)
        .isEqualTo(expectedValueInShowDropdown);

    String actualValueInSortDropdown = new DesktopsPage().getValueFromSortSelect();

    softAssertions.assertThat(actualValueInSortDropdown)
        .as("We are waiting for the next value from the SortDropdown" + expectedValueInSortDropdown)
        .isEqualTo(expectedValueInSortDropdown);

    List<ProductBlock> allProductsFromPage = new DesktopsPage().getAllProductsFromPage();
    softAssertions.assertThat(allProductsFromPage)
        .as("We are waiting that number of products on the page will be "
            + expectedNumberOfProductsOnPage)
        .hasSize(expectedNumberOfProductsOnPage);

    List<ProductBlock> allProductsFromPageAfterSelection = new DesktopsPage()
        .selectTheNumberOfShowingElementsOnThePage(SHOW_25)
        .getAllProductsFromPage();

    softAssertions.assertThat(allProductsFromPageAfterSelection)
        .as("We are waiting that number of products on the page after selection 25 will be "
            + expectedNumberOfProductsOnPageAfterSelection)
        .hasSize(expectedNumberOfProductsOnPageAfterSelection);

    String actualTextOnTheBottomOfThePage = new DesktopsPage()
        .getTextOnTheBottomOfThePage();

    softAssertions.assertThat(actualTextOnTheBottomOfThePage)
        .as("We are waiting for next text on the bottom of the page "
            + expectedTextOnTheBottomOfThePage)
        .isEqualTo(expectedTextOnTheBottomOfThePage);

    softAssertions.assertAll();
  }
}

