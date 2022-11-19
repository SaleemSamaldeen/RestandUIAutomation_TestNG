package AutomationTask;

import Pages.RestServices;
import Utils.TestDataReader;
import Utils.TestSetup;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Check24TC01 extends TestSetup {

    @BeforeTest
    public void bt() {
        category = "Smoke";
        author = "Saleem Samaldeen";
        testCaseName = "CHECK24";
        testNodes = "TC01";
        testDescription = "Verify REST-Webservice test task";
    }

    public RestServices restServices;

    @Test(dataProvider = "GenericDataProvider", dataProviderClass = TestDataReader.class, testName = "RestAPITask",
            description = "Verify REST-Webservice test task")
    public void googleSearch(String endpoint, String parameter) throws IOException, ParseException {
        restServices = new RestServices(test);
        restServices.getJSONResponseBody(endpoint,parameter);
    }
}
