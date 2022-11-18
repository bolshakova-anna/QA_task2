package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginPage extends BasePage<LoginPage>{
  @Rule
  public ScreenShooter screenShooter = ScreenShooter.failedTests();

  public static final String url = "https://ok.ru/";
  public static final String loginErrorTextXPAtr = "//*[@class='input-e login_error']";
  private static final String loginFieldXPath = "//*[@id='field_email']";
  private static final String passwordFieldXPath = "//*[@id='field_password']";
  public LoginPage(){
    super();
  }

  @Override
  protected void check(){
    $(By.xpath(loginFieldXPath)).shouldBe(Condition.visible.because("Не отобралились поля ввода"));
    $(By.xpath(passwordFieldXPath)).shouldBe(Condition.visible.because("Не отобралились поля ввода"));
  }

  public LoginPage login(String OKUsername,String OKPassword) {
    $(By.xpath(loginFieldXPath)).val(OKUsername);
    $(By.xpath(passwordFieldXPath)).val(OKPassword).pressEnter();
    return this;
  }

  public LoginPage login(UserTestBot userTestBot) {
    $(By.xpath(loginFieldXPath)).val(userTestBot.getLogin());
    $(By.xpath(passwordFieldXPath)).val(userTestBot.getPassword()).pressEnter();
    return this;
  }

}
