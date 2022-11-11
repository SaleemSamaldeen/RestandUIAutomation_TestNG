package Pages;

import Utils.TestSetup;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CreditCardPage extends TestSetup {

    public WebDriverWait wait;

    public CreditCardPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
    }

    int timeout = 50;

    @FindBy(xpath = "//a[@title='iPhone 12 mit Vertrag']")
    public WebElement iphone12WithContract;

    @FindBy(xpath = "//a[text()='Akzeptieren']")
    public WebElement cookies;

    @FindBy(xpath = "//span[(text()='1.')]//following::a[text()='weiter'][1]")
    public WebElement firstProductWeiterButton;

    @FindBy(xpath = "//input[@type='email' and @id='cl_login']")
    public WebElement enterEmailAddress;

    @FindBy(xpath = "//button[@id='c24-uli-login-btn']//span")
    public WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'cl-r-anonym')]//div[contains(@class,'cl-box-option')]")
    public WebElement checkBox;

    @FindBy(xpath = "//button[@id='c24-uli-register-btn']")
    public WebElement registerButton;

    @FindBy(xpath = "//a[text()='weiter']")
    public WebElement formPageWeiterButton;

    @FindBy(xpath = "//div[@type='ERROR']")
    public List<WebElement> allErrorMessages;

    @FindBy(xpath = "//input[@id='LAST_NAME']")
    private WebElement lastName;


    public void acceptCookies() {
        String value = driver.manage().getCookieNamed("ppset").getValue();
        Assert.assertTrue(value.equalsIgnoreCase("kreditkarte"));
        reportStep("Verify if Title is displayed as kreditkarte", String.valueOf(value.equalsIgnoreCase("kreditkarte")));
        if (cookies.isDisplayed())
            reportStep("Cookie is displayed", "info");
        cookies.click();
    }

    public void creditCardRegistrationFlow(String email) throws InterruptedException {
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", firstProductWeiterButton);
        firstProductWeiterButton.click();
        waitUntilElementLocated("//input[@type='email' and @id='cl_login']", "Email field");
        enterEmailAddress.sendKeys(email);
        waitUntilElementLocated("//button[@id='c24-uli-login-btn']", "Login Button");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("locator")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", registerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", formPageWeiterButton);
        for (WebElement allErrorMessage : allErrorMessages) {
            String text = allErrorMessage.getText().trim();
            reportStep("Error Messages: " + text, "info");
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + email + "')", lastName);
    }

    public void waitUntilElementLocated(String locator, String locatorName) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        if (!driver.findElement(By.xpath(locator)).isDisplayed()) {
            reportStep(locatorName + " locator is not present in webpage", "FAIL", true);
        }
    }

}
