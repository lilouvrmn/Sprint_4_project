package praktikum.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

public class StatusPage {

    private final By notFoundImage = By.cssSelector("[alt='Not found']");
    private final WebDriver driver;

    public StatusPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkNotFound() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(notFoundImage));

        assert driver.findElement(notFoundImage).isDisplayed();
    }

}
