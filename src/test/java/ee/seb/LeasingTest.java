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
        open("http://www.seb.ee/eng/loan-and-leasing/leasing/car-leasing#calculator");
        $("body > div.seb-cookie-consent.seb-cookiemessage > div > div:nth-child(4) > ul > li:nth-child(1) > a").click();
        $("body > div.seb-cookie-consent.seb-cookiemessage > div > div.header-cookie-message").shouldNot(Condition.visible);
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
    }
}
