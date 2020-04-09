package ee.seb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;


public class LoginPage {

    private SelenideElement login = $("#headermain");

    public LoginPage checkUserIsOnLoginPage() {
        switchTo().window(1);
        login.shouldBe(Condition.visible);
        assert(url().contains("ip/ipank.p?act=LOGIN&act2=CRMCONTACT&topic_code=t_lseauto&lang=ENG"));
        return this;
    }
}
