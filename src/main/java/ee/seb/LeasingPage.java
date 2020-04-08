package ee.seb;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class LeasingPage {

    // Leasing locators
    public SelenideElement menuBar = $("#block-seb-dropdown-menu");
    public SelenideElement pathrow = $("#box04 > ul");
    public SelenideElement loanAndLeasingHeader = $(withText("Loan and  Leasing"));
    public SelenideElement submitViaIBankButton = $(byText("Submit an application in the Internet Bank"));
    public SelenideElement submitViaWebsiteButton = $(byText("Submit an application on the website of SEB"));

    public LoginPage submitApplicationViaIBank() {
        submitViaIBankButton.click();
        return new LoginPage();
    }

    public LeasingPage submitApplicationViaWebsite() {
        submitViaWebsiteButton.click();
        return this;
    }

    public LeasingPage checkMenuIsSelected(String title) {
        loanAndLeasingHeader.find(Selectors.byText(title)).shouldNotHave(Condition.attribute("href"));
        return this;
    }
}
