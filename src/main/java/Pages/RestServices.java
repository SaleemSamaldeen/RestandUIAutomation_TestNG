package Pages;

import Utils.TestSetup;
import com.aventstack.extentreports.ExtentTest;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class RestServices extends TestSetup{

    public RestServices(ExtentTest test) {
        this.test = test;
    }
    JSONFileReader jsonFileReader;

    public void getJSONResponseBody(String endpoint, String parameter) throws IOException, ParseException {
        //Base URI to hit the server
        RestAssured.baseURI = endpoint;
        //Request Specification for above Base URI
        RequestSpecification requestSpec = RestAssured.given();
        //Get request method to fetch request details
        Response response = requestSpec.request(Method.GET, parameter);

        reportStep("Status code: " + response.getStatusCode(),"info", false);
        reportStep("Status line: " + response.getStatusLine(),"info",false);
        response.jsonPath().get("tabs");
        try {
            Map<String, Object> responseMap = response.jsonPath().get("tabs");
            for (Map.Entry<String, Object> entry : responseMap.entrySet()) {
                reportStep("Tab headers from Response body - " +entry.getKey(),"info");
            }
        } catch (Exception e) {
            reportStep("Error in getting value from Response body","warning");
            throw new RuntimeException("Error in getting value from Response body");
        }
    }
}
