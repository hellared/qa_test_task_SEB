package ee.seb;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LeasingTest extends BaseTest{
    protected LeasingPage leasingPage = new LeasingPage();
    protected AcceptCookieModal acceptCookieModal = new AcceptCookieModal();
    @BeforeEach
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
    @Test
    public void testCanReachLeasingPage() {
        Selenide.open("/loan-and-leasing/leasing/car-leasing#calculator");
        leasingPage.checkMenuIsSelected("Loan and  Leasing");
        leasingPage.checkMenuIsSelected("Car leasing");
        
    }
    @Test
    public void testCanSubmitApplication() {
        leasingPage.submitApplicationViaIBank()
                .checkUserIsOnLoginPage();
    }
//    @Test
//    public void applyForLeasingWithAllFields() {
//        Selenide.open("/loan-and-leasing/leasing/car-leasing#calculator");
//        System.out.println("Test");
//        clearBrowserCookies();
//        System.out.println("AfterEach");
//        $("body > div.seb-cookie-consent.seb-cookiemessage > div > div:nth-child(4) > ul > li:nth-child(1) > a").click();
//        $("body > div.seb-cookie-consent.seb-cookiemessage > div > div.header-cookie-message").shouldNot(Condition.visible);
//
//        $("#coApplicant").scrollTo();
//        $("#coApplicant").setSelected(true);
//        $("#netoIncome").setValue("2000");
//        $("#monthlyFinancialObligations").setValue("500");
//        $("#numOfDependants").setValue("2");
//
//        $("#leaseSum").shouldHave(Condition.text("12 320"));
//        $("#resultWrapperNumber > div.buttons-container")
//                .shouldBe(Condition.visible);
//        $("#resultWrapperNumber > div.buttons-container")
//                .shouldBe(Condition.enabled).click();
//        $("#TB_main").shouldBe(Condition.visible);
//        $("#TB_content_container > div > ul > li:nth-child(2) > a").click();
//        switchTo().window(1);
//        assertThat(url()).contains("ip/ipank.p?act=CRMCONTACT&topic_code=t_lseauto&pt=unknown");
//    }
}
