package ee.seb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;


public class LoginPage {

    private final SelenideElement login = $("#headermain");
    private final int windowNumber = 1;
    private final String urlPart = "ip/ipank.p?act=LOGIN&act2=CRMCONTACT&topic_code=t_lseauto&lang=ENG";

    @Step
    public LoginPage checkUserIsOnLoginPage() {
        switchTo().window(windowNumber);
        login.shouldBe(Condition.visible);
        assert(url().contains(urlPart));
        return this;
    }
}
