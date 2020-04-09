package ee.seb;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.switchTo;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LeasingTest extends BaseTest {

    protected LeasingPage leasingPage = new LeasingPage();
    protected SubmitApplicationPage submitApplicationPage = new SubmitApplicationPage();
    protected AcceptCookieModal acceptCookieModal = new AcceptCookieModal();

    @BeforeAll
    public void openPage() {
        Selenide.open("/loan-and-leasing/leasing/car-leasing#calculator");
        acceptCookieModal.checkModalText(
                "What do we use cookies for?",
                "To offer you the best possible browsing experience, we use cookies on our website. To learn more view our ",
                "Manage cookie settings",
                "I agree"
        );
        acceptCookieModal.acceptAction();
    }

    @BeforeEach
    public void refreshPage() {
        Selenide.refresh();
    }

    @AfterEach
    public void returnToPage() {
        switchTo().window(0);
    }

    @Test
    public void testCanAddToComparison() {
        leasingPage.openCarLeasingCalculator()
                .setVehiclePrice("50000")
                .setDownpayments("3")
                .applyComparison();
        leasingPage.monthlyPayments.shouldNotBe(Condition.empty);
        leasingPage.comparisonBlock.should(Condition.appear).shouldNotBe(Condition.empty);
    }

    @Test
    public void testCanSeeSchedule() {
        leasingPage.openCarLeasingCalculator()
                .setVehiclePrice("50000")
                .setDownpayments("3")
                .applySchedule();
        leasingPage.scheduleBlock.should(Condition.appear).shouldNotBe(Condition.empty);
    }

    @Test
    public void testCanReachLeasingPage() {
        leasingPage.checkMenuIsSelected("Loan and  Leasing")
                .checkMenuIsSelected("Car leasing");
    }

    @Test
    public void testCanSubmitApplication() {
        leasingPage.submitApplicationViaIBank()
                .checkUserIsOnLoginPage();
        Selenide.closeWindow();
    }

    @Test
    public void applyForLeasingWithAllFields() {
        leasingPage
                .setNetIncome("2000")
                .setFinancialObligations("500")
                .setDependants("2")
                .applySurety();
        leasingPage.leaseSum.shouldHave(Condition.text("20 530"));
        leasingPage.resultSum.shouldBe(Condition.visible);
        leasingPage.resultButtons.shouldBe(Condition.visible)
                .shouldBe(Condition.enabled);
        leasingPage.proceedToApplication()
                .submitApplication();
        submitApplicationPage.checkUserIsOnSubmitApplicationPage();
        Selenide.closeWindow();
    }
}
