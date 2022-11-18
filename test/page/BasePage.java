package page;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Configuration.*;


public abstract class BasePage<T> {
    public T openPage(T t){
        open("/");
        return t;
    }

    public T openPage(T t, String url){
        baseUrl = url;
        open("/");
        return t;
    }
    protected void checkPage(){

    }

    protected abstract void check();
}
