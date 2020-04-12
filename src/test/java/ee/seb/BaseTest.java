package ee.seb;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


public class BaseTest {
    @BeforeClass
    public void registerSelenideListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://www.seb.ee/eng";
    }

    @AfterAll
    public static void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }
}

