package AutomationTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static io.qameta.allure.Allure.step;

@Feature("Check Allure report with JUnit")
@TmsLink("TC01")
@Severity(SeverityLevel.NORMAL)
@Tag("Sanity")
class TestCase01 {

    public static WebDriver driver;

    @BeforeAll
    static void launchComputerDatabase(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/electronics");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    @Description("Launch computer database")
    @DisplayName("Verify test test to launch computer database")
    void launchComputerDatabaseTitle(){
        step("Click Register link",() -> {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        });
    }

    @Test
    @Description("Register computer database")
    @DisplayName("Verify test to register computer database")
    void registerComputerDatabaseTitle(){
        step("Click Register without entering values",() -> {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        });
    }
}
