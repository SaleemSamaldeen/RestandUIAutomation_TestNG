package AutomationTask;

import Pages.CreditCardPage;
import Pages.RestServices;
import Utils.TestDataReader;
import Utils.TestSetup;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

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
    public void fillInCreditCard(String email) throws InterruptedException, IOException, ParseException {
        creditCardPage = new CreditCardPage(driver, test);
        reportStep("Step 1: Accept cookies","info",false);
        creditCardPage.acceptCookies();
        reportStep("Step 2: Credit card registration","info",false);
        creditCardPage.creditCardRegistrationFlow(email);
    }
}
