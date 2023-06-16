import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class Test0 extends BaseTest {

  @Test
  public void checkThatBrandsExistsOnPageTest() {

    List<String> expectedBrandNames = new ArrayList<>();
    expectedBrandNames.add("Apple");
    expectedBrandNames.add("Canon");
    expectedBrandNames.add("Hewlett-Packard");
    expectedBrandNames.add("HTC");
    expectedBrandNames.add("Palm");
    expectedBrandNames.add("Sony");

    MainPage mainPage = new MainPage();

    List<String> actualBrandNames = mainPage
        .getFooterBlock()
        .clickOnBrandsButton()
        .allBrandNames();

    Assertions.assertThat(expectedBrandNames)
        .as("We are waiting for the following brands on the page " + expectedBrandNames)
        .containsAll(actualBrandNames);
  }
}
