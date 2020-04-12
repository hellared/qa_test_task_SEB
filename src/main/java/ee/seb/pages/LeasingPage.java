package ee.seb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import ee.seb.modals.LoginModal;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

@Getter
public class LeasingPage {

    // Leasing locators
    private final SelenideElement loanAndLeasingHeader = $(withText("Loan and  Leasing"));
    private final SelenideElement submitViaIBankButton = $(byText("Submit an application in the Internet Bank"));

    // Car leasing calculator
    private final SelenideElement carLeasingTab = $(byText("Car leasing calculator"));
    private final String carFrame = "calculator-frame-08a";
    private final SelenideElement vehiclePrice = $("#calc08-sum");
    private final SelenideElement downpayment = $("#calc08-deposit");
    private final SelenideElement monthlyPayments = $("monthly-result");
    private final SelenideElement comparisonButton = $(byValue("Add to comparison"));
    private final SelenideElement scheduleButton = $(byValue("Schedule"));
    private final SelenideElement comparisonBlock = $(".calc-result-compare");
    private final SelenideElement scheduleBlock = $(".calc-result-graph");

    // Maximum lease calculator
    private final SelenideElement netIncome = $("#netoIncome");
    private final SelenideElement financialObligations = $("#monthlyFinancialObligations");
    private final SelenideElement dependants = $("#numOfDependants");
    private final SelenideElement suretyCheckbox = $(byText("Apply with a surety"));
    private final SelenideElement leaseSum = $("#leaseSum");
    private final SelenideElement resultSum = $("#resultWrapperNumber > div.buttons-container");
    private final SelenideElement resultButtons = $("#resultWrapperNumber > div.buttons-container");

    @Step
    public LoginPage submitApplicationViaIBank() {
        submitViaIBankButton.click();
        return new LoginPage();
    }

    @Step
    public LeasingPage checkMenuIsSelected(String title) {
        loanAndLeasingHeader.find(Selectors.byText(title)).shouldNotHave(Condition.attribute("href"));
        return this;
    }

    @Step
    public LeasingPage setNetIncome(String sum) {
        netIncome.setValue(sum);
        return this;
    }

    @Step
    public LeasingPage setFinancialObligations(String sum) {
        financialObligations.setValue(sum);
        return this;
    }

    @Step
    public LeasingPage setDependants(String sum) {
        dependants.setValue(sum);
        return this;
    }

    @Step
    public LeasingPage applySurety() {
        suretyCheckbox.click();
        return this;
    }

    @Step
    public LoginModal proceedToApplication() {
        resultButtons.click();
        return new LoginModal();
    }

    @Step
    public LeasingPage openCarLeasingCalculator() {
        carLeasingTab.click();
        switchTo().frame(carFrame);
        return this;
    }

    @Step
    public LeasingPage setVehiclePrice(String sum) {
        vehiclePrice.setValue(sum);
        return this;
    }

    @Step
    public LeasingPage setDownpayments(String sum) {
        downpayment.setValue(sum);
        return this;
    }

    @Step
    public LeasingPage applyComparison() {
        comparisonButton.click();
        return this;
    }

    @Step
    public LeasingPage applySchedule() {
        scheduleButton.click();
        return this;
    }
}
