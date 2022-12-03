package page;

import org.junit.BeforeClass;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Configuration.*;


public abstract class BasePage<T> {
    @BeforeClass
    protected void checkPage(){

    }

    protected abstract void check();
}
