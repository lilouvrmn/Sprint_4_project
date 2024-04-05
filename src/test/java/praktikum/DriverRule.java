package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverFactory extends ExternalResource {

        private WebDriver driver;

        @Override
        protected void before() throws Throwable{
            initDriver();

        }
    @Override
    protected void after() {
        driver.quit();

    }

        public void initDriver() {
            if ("firefox".equals(System.getProperty("browser"))) {
                initFirefox();
            }
            else{
                initChrome();
            }
        }

        private void initFirefox() {
            WebDriverManager.firefoxdriver().setup();
//            System.setProperty("webdriver.gecko.driver", "/Users/lilou/your/path/geckodriver");
            var opts = new FirefoxOptions();
            opts.configureFromEnv();
            driver = new FirefoxDriver(opts);
        }

        private void initChrome() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        public WebDriver getDriver() {
            return driver;
        }

    }

