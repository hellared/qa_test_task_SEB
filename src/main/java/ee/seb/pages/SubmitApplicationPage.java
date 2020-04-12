package ee.seb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SubmitApplicationPage {

    private final SelenideElement header = $("#headermain");
    private final int windowNumber = 1;
    private final String headerText = "Sõidukiliising";
    private final String urlPart = "ip/ipank.p?act=CRMCONTACT&topic_code=t_lseauto";

    @Step
    public SubmitApplicationPage checkUserIsOnSubmitApplicationPage() {
        switchTo().window(windowNumber);
        header.shouldBe(Condition.visible)
                .shouldHave(Condition.text(headerText));
        assert (url().contains(urlPart));
        return this;
    }
}
