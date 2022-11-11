package Pages;

import Utils.TestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonPages extends TestSetup {


    public void waitUntilElementLoaded(WebDriver driver, int timeout, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void closeCurrentSession(WebDriver driver) {
        driver.close();
    }


}
