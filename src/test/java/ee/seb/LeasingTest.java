package ee.seb;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;


public class LeasingTest {
    @Test
    public void testCanReachLeasingPage() {
        // Open page
        open("http://www.seb.ee/eng/loan-and-leasing/leasing/car-leasing#calculator");
        $("body > div.seb-cookie-consent.seb-cookiemessage > div > div:nth-child(4) > ul > li:nth-child(1) > a").click();
        // Accept cookies
        $("body > div.seb-cookie-consent.seb-cookiemessage > div > div.header-cookie-message").shouldNot(Condition.visible);
        // Check titles of the menu bar
        $("#box04 > ul > li:nth-child(3) > div").shouldNot(Condition.have(Condition.attribute("href")));
        $("#box04 > ul > li.last > div").shouldNot(Condition.have(Condition.attribute("href")));
        // Clear cache
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void testCanSubmitApplication() {
        open("http://www.seb.ee/eng/loan-and-leasing/leasing/car-leasing#calculator");
        $("body > div.seb-cookie-consent.seb-cookiemessage > div > div:nth-child(4) > ul > li:nth-child(1) > a").click();
        $("body > div.seb-cookie-consent.seb-cookiemessage > div > div.header-cookie-message").shouldNot(Condition.visible);

        $("#node-3465 > div.productinfo01 > div.productinfo01-b > div.longtext > div.field.field-name-body.field-type-text-with-summary.field-label-hidden > div > div > ul > li > a")
                .should(Condition.exactText("Submit an application in the Internet Bank"))
                .click();
        switchTo().window(1);
        assertThat(url()).contains("ip/ipank.p?act=LOGIN&act2=CRMCONTACT&topic_code=t_lseauto&lang=ENG");
        // Clear cache
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
    @Test
    public void applyForLeasingWithAllFields() {
        open("http://www.seb.ee/eng/loan-and-leasing/leasing/car-leasing#calculator");
        $("body > div.seb-cookie-consent.seb-cookiemessage > div > div:nth-child(4) > ul > li:nth-child(1) > a").click();
        $("body > div.seb-cookie-consent.seb-cookiemessage > div > div.header-cookie-message").shouldNot(Condition.visible);

        $("#coApplicant").scrollTo();
        $("#coApplicant").setSelected(true);
        $("#netoIncome").setValue("2000");
        $("#monthlyFinancialObligations").setValue("500");
        $("#numOfDependants").setValue("2");

        $("#leaseSum").shouldHave(Condition.text("12 320"));
        $("#resultWrapperNumber > div.buttons-container")
                .shouldBe(Condition.visible);
        $("#resultWrapperNumber > div.buttons-container")
                .shouldBe(Condition.enabled).click();
        $("#TB_main").shouldBe(Condition.visible);
        $("#TB_content_container > div > ul > li:nth-child(2) > a").click();
        switchTo().window(1);
        assertThat(url()).contains("ip/ipank.p?act=CRMCONTACT&topic_code=t_lseauto&pt=unknown");


    }
}
