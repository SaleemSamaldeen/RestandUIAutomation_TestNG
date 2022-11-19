package AutomationTask;

import Pages.CreditCardPage;
import Utils.TestDataReader;
import Utils.TestSetup;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Check24TC02 extends TestSetup {

    @BeforeTest
    public void bt() {
        category = "Smoke";
        author = "Saleem Samaldeen";
        testCaseName = "CHECK24 Web Task";
        testNodes = "TC02";
        testDescription = "Fill in Credit Card Registration form";
    }

    public CreditCardPage creditCardPage;

    @Test(dataProvider = "GenericDataProvider", dataProviderClass = TestDataReader.class, testName = "CreditCard",
            description = "Fill in Credit Card Registration form")
    public void fillInCreditCard(String email) throws InterruptedException {
        creditCardPage = new CreditCardPage(driver, test);
        reportStep("Step 1: Accept cookies","info",false);
        creditCardPage.acceptCookies();
        reportStep("Step 2: Credit card registration","info",false);
        creditCardPage.creditCardRegistrationFlow(email);
    }
}
