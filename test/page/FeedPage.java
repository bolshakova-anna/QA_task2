package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class FeedPage extends BasePage<FeedPage> {
    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();
    private static String musicToolbarButtonXPath = "//*[@id=\"music_toolbar_button\"]";

    public FeedPage(){
        super();
    }

    @Override
    protected void check() {
    $(By.xpath(musicToolbarButtonXPath)).shouldBe(Condition.visible);
    }

    public MusicLayerPage openMusicFromToolbar(){
        $(By.xpath(musicToolbarButtonXPath)).click();
        return new MusicLayerPage();
    }

}
