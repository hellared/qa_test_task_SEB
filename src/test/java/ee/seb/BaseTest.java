package ee.seb;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.baseUrl="https://www.seb.ee/eng";
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 20000;
        Configuration.headless = false;
    }
   @AfterAll
   public static void tearDown() {
       WebDriverRunner.getWebDriver().quit();
   }
}
