package ee.seb.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AcceptCookieModal {

    private SelenideElement dialogMessage = $(".content-cookie-message");
    private SelenideElement acceptButton = $(".accept-selected");
    private SelenideElement manageButton = $(".cookie-settings");

    @Step
    public AcceptCookieModal acceptAction() {
        acceptButton.click();
        return this;
    }

    @Step
    public AcceptCookieModal manageAction() {
        manageButton.click();
        return this;
    }

    @Step
    public AcceptCookieModal checkModalText(String title, String message, String manage, String accept) {
        dialogMessage.shouldHave(text(title));
        dialogMessage.shouldHave(text(message));
        manageButton.shouldHave(text(manage));
        acceptButton.shouldHave(text(accept));
        return this;
    }
}
