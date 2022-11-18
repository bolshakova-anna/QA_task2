package test;

import highlighter.Highlighter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class BaseTest {
  private static  final int defaultTimeout = 10000;
  private static  final boolean defaultStartMaximized = false;
  private static  final String defaultBrowser = "chrome";
  private static  final String defaultBrowserPosition = "890x10";
  private static  final String defaultBrowserSize = "780x950";

  @BeforeClass
  public static void setupBrowser() {
    timeout = defaultTimeout;
    startMaximized = defaultStartMaximized;
    browser = defaultBrowser;
    browserPosition = defaultBrowserPosition;
    browserSize = defaultBrowserSize;
    addListener(new Highlighter());
  }

  @AfterClass
  public static void logout() {
    closeWebDriver();
  }

  }

