package AutomationTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Check Allure report with JUnit")
@TmsLink("TC01")
@Severity(SeverityLevel.NORMAL)
@Tag("Sanity")
class TestCase01 {

    WebDriver driver;

    @BeforeClass
    void launchComputerDatabase(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/electronics");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(priority = 1)
    @Story("Launch computer database")
    @Description("Launch computer database")
    void launchComputerDatabaseTitle(){
        step("Click Register link",() -> {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
            assertThat(driver.getTitle()).isEqualTo("Saleem Samaldeen");
        });
    }

    @Test(priority = 2)
    @Story("Register computer database")
    @Description("Register computer database")
    void registerComputerDatabaseTitle(){
        step("Click Register without entering values",() -> {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        });
    }

    @Test(priority = 3)
    @Description("Fill computer database details")
    void fillForm() {
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("firstName");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("lastName");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("gmail");
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
    }
}
