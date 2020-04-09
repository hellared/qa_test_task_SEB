package ee.seb;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

@Slf4j
public class BaseTest {
    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl="https://www.seb.ee/eng";
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 20000;
        Configuration.headless = true;
    }
   @AfterAll
   public static void tearDown() {
       WebDriverRunner.getWebDriver().quit();
   }
}

