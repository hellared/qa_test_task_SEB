package ee.seb.modals;

import com.codeborne.selenide.SelenideElement;
import ee.seb.pages.LeasingPage;
import ee.seb.pages.SubmitApplicationPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;

public class LoginModal {

    private final SelenideElement closeButton = $(".close");
    private final SelenideElement applicationButton = $(".-CS-aplication-button");

    @Step
    public LeasingPage closeModal() {
        closeButton.click();
        closeButton.should(disappear);
        return new LeasingPage();
    }

    @Step
    public SubmitApplicationPage submitApplication() {
        applicationButton.click();
        return new SubmitApplicationPage();
    }
}
