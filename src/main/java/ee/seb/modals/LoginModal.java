package ee.seb.modals;

import com.codeborne.selenide.SelenideElement;
import ee.seb.pages.LeasingPage;
import ee.seb.pages.SubmitApplicationPage;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;

public class LoginModal {

    private SelenideElement closeButton = $(".close");
    private SelenideElement applicationButton = $(".-CS-aplication-button");

    public LeasingPage closeModal() {
        closeButton.click();
        closeButton.should(disappear);
        return new LeasingPage();
    }
    public SubmitApplicationPage submitApplication() {
        applicationButton.click();
        return new SubmitApplicationPage();
    }
}
