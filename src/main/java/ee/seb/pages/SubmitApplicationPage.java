package ee.seb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SubmitApplicationPage {

    private SelenideElement header = $("#headermain");

    @Step
    public SubmitApplicationPage checkUserIsOnSubmitApplicationPage() {
        switchTo().window(1);
        header.shouldBe(Condition.visible)
                .shouldHave(Condition.text("Sõidukiliising"));
        assert (url().contains("ip/ipank.p?act=CRMCONTACT&topic_code=t_lseauto"));
        return this;
    }
}
