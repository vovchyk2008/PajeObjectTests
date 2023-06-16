import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class Test1 extends BaseTest {

  private final String email = faker.internet().emailAddress();
  private final String expectedTextFromAlert = "Warning: The E-Mail Address was not found in our records!";

  @Test
  public void checkRedirectionToNewPageTest() {

    MainPage mainPage = new MainPage();
    String textFromAlert = mainPage.
        getCurrencyAndLoginBlock()
        .clickOnMyAccountButton()
        .clickOnLoginButton()
        .clickOnForgetPasswordButton()
        .enterEmail(email)
        .clickOnContinueButton()
        .getTextFromAlert();

    Assertions.assertThat(textFromAlert)
        .as("We are waiting for the next text from the alert" + expectedTextFromAlert)
        .isEqualTo(expectedTextFromAlert);
  }
}