package test;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import page.FeedPage;
import page.LoginPage;
import page.MusicLayerPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class MusicTest extends BaseTest {
    private static String OKUsername = System.getProperty("OK.username", "technoPol27");
    private static String OKPassword = System.getProperty("OK.password", "technoPolis2022");
    private static String OKMusicRequest = System.getProperty("OK.musicRequest", "Звери - для тебя");
    private static String OKMusicName = System.getProperty("OK.musicName", "Для тебя");

    /*Тест, проверяющий сценарий:
    * Залогиниться на OK.ru,
    * зайти в раздел "Музыка",
    * найти песню "Звери - для тебя",
    * добавить его
    * и проверить, отображается ли трек во вкладке "Моя музыка"
    * */
    @DisplayName("Проверка сценария добавления юзером трека Звери - Для тебя после логина")
    @Test
    public void addMusicTest(){
        LoginPage loginpage = new LoginPage();
        FeedPage feedPage = new FeedPage();
        loginpage.openPage(loginpage,loginpage.url)
                        .login(OKUsername,OKPassword);

        MusicLayerPage musicLayerPage = feedPage.openMusicFromToolbar(); //возвращает MusicLayerPage
        musicLayerPage.searchMusic(OKMusicRequest)
        .addMusic()
        .openMyMusic();
        $(By.xpath(musicLayerPage.myMusicListInfoXpath))
            .shouldHave(text(OKMusicName))
            .shouldBe(visible);
    }

}
