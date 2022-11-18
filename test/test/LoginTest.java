package test;

import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import page.LoginPage;
import page.UserTestBot;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@DisplayName("Проверка логина юзера")
public class LoginTest extends BaseTest{
  private static String OKUsername = System.getProperty("OK.username", "technoPol27");
  private static String OKPassword = System.getProperty("OK.password", "technoPolis2022");
  private static String OKName = System.getProperty("OK.idName", "technoPol27 technoPol27");
  private static By USERNAME_IN_NAVIGATION = By.xpath("//div[@class='tico ellip']");

  @DisplayName("Проверка невозможности логина юзера при неверном пароле")
  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = {"technoPolis", "aaawda", " ", "help"})
  public void FailedLoginWithWrongPassword(String password){
    UserTestBot bot = new UserTestBot(OKUsername,OKPassword,OKName);
    LoginPage loginpage = new LoginPage();
    loginpage.openPage(loginpage,loginpage.url)
            .login(bot);
    $(By.xpath(loginpage.loginErrorTextXPAtr)).
            shouldHave(text("Неправильно указан логин и/или пароль"));
  }

  @DisplayName("Проверка возможности логина юзера при верном пароле")
  @Test
  public void LoginShowsCorrectName() {
    LoginPage loginpage = new LoginPage();
    loginpage.openPage(loginpage,loginpage.url)
            .login(OKUsername,OKPassword);
    $(USERNAME_IN_NAVIGATION)
            .shouldHave(text(OKName))
            .shouldBe(visible);
  }
}
