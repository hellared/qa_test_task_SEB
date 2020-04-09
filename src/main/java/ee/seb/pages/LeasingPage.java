package ee.seb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import ee.seb.modals.LoginModal;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class LeasingPage {

    // Leasing locators
    public SelenideElement loanAndLeasingHeader = $(withText("Loan and  Leasing"));
    public SelenideElement submitViaIBankButton = $(byText("Submit an application in the Internet Bank"));

    // Car leasing calculator
    public SelenideElement carLeasingTab = $(byText("Car leasing calculator"));
    public SelenideElement vehiclePrice = $("#calc08-sum");
    public SelenideElement downpayment = $("#calc08-deposit");
    public SelenideElement monthlyPayments = $("monthly-result");
    public SelenideElement comparisonButton = $(byValue("Add to comparison"));
    public SelenideElement scheduleButton = $(byValue("Schedule"));
    public SelenideElement comparisonBlock = $(".calc-result-compare");
    public SelenideElement scheduleBlock = $(".calc-result-graph");

    // Maximum lease calculator
    public SelenideElement netIncome = $("#netoIncome");
    public SelenideElement financialObligations = $("#monthlyFinancialObligations");
    public SelenideElement dependants = $("#numOfDependants");
    public SelenideElement suretyCheckbox = $(byText("Apply with a surety"));
    public SelenideElement leaseSum = $("#leaseSum");
    public SelenideElement resultSum = $("#resultWrapperNumber > div.buttons-container");
    public SelenideElement resultButtons = $("#resultWrapperNumber > div.buttons-container");

    public LoginPage submitApplicationViaIBank() {
        submitViaIBankButton.click();
        return new LoginPage();
    }
    public LeasingPage checkMenuIsSelected(String title) {
        loanAndLeasingHeader.find(Selectors.byText(title)).shouldNotHave(Condition.attribute("href"));
        return this;
    }
    public LeasingPage setNetIncome(String sum) {
        netIncome.setValue(sum);
        return this;
    }
    public LeasingPage setFinancialObligations(String sum) {
        financialObligations.setValue(sum);
        return this;
    }
    public LeasingPage setDependants(String sum) {
        dependants.setValue(sum);
        return this;
    }
    public LeasingPage applySurety() {
        suretyCheckbox.click();
        return this;
    }
    public LoginModal proceedToApplication() {
        resultButtons.click();
        return new LoginModal();
    }
    public LeasingPage openCarLeasingCalculator() {
        carLeasingTab.click();
        switchTo().frame("calculator-frame-08a");
        return this;
    }
    public LeasingPage setVehiclePrice(String sum) {
        vehiclePrice.setValue(sum);
        return this;
    }
    public LeasingPage setDownpayments(String sum) {
        downpayment.setValue(sum);
        return this;
    }
    public LeasingPage applyComparison() {
        comparisonButton.click();
        return this;
    }
    public LeasingPage applySchedule() {
        scheduleButton.click();
        return this;
    }
}
