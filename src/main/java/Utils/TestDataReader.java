package Utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class TestDataReader extends ConfigReader {

    @DataProvider(name = "GenericDataProvider")
    public static Object[][] getExcelData(Method m) {
        String testSheet = (m.getAnnotation(Test.class)).testName();
        return DataInputProvider.getSheet(testSheet);
    }
}
