package ee.seb;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AcceptCookieModal {

    private SelenideElement dialogMessage = $(".content-cookie-message");
    private SelenideElement acceptButton = $(".accept-selected");
    private SelenideElement manageButton = $(".cookie-settings");

    public AcceptCookieModal acceptAction() {
        acceptButton.click();
        acceptButton.should(disappear);
        return this;
    }

    public AcceptCookieModal manageAction() {
        manageButton.click();
        manageButton.should(disappear);
        return this;
    }

    public AcceptCookieModal checkModalText(String title, String message, String manage, String accept) {
        dialogMessage.shouldHave(text(title));
        dialogMessage.shouldHave(text(message));
        manageButton.shouldHave(text(manage));
        acceptButton.shouldHave(text(accept));
        return this;
    }
}
