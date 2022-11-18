package page;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MusicLayerPage extends BasePage<MusicLayerPage>{
    public static final String musicSearchFieldXpath1 = "//*[@placeholder=\"Поиск\" and @data-l=\"t,input\"]";
    public static final String musicSearchFieldXpath2 = "//*[@id=\"music_layer\"]/header/div/wm-search-form/wm-search-input/input";
    public static final String musicListElementXPath = "//a[contains(@data-payload, \"artistName=Звери\")]/../..";
    public static final String addMusicButtonXPath = "//*[@title=\"В мою музыку\"]";
    public static final String myMusicButtonXPath = "//div[text()=\"Моя музыка\"]";
    public static final String myMusicListInfoXpath = "//*[@id='music_layer']//wm-tracks-list//wm-track//wm-card-details/slot";

    public MusicLayerPage(){
        super();
    }

    @Override
    protected void check() {
    $(By.xpath(musicSearchFieldXpath1)).shouldBe(Condition.visible);
    }

    public MusicLayerPage searchMusic(String name){
        $(By.xpath((musicSearchFieldXpath1))).click();
        $(By.xpath((musicSearchFieldXpath2))).val(name).pressEnter();
        return this;

    }

    public MusicLayerPage addMusic(){
        $(By.xpath(musicListElementXPath)).click();
        $(By.xpath(addMusicButtonXPath)).click();
        return this;
    }

    public MusicLayerPage openMyMusic(){
        $(By.xpath(myMusicButtonXPath)).click();
        return this;
    }

}
