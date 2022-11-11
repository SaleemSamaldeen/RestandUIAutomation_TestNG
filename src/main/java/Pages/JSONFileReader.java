package Pages;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class JSONFileReader {

    public void fileReader() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/test/java/AutomationTask/check24.json"));
        Map<String, Object> data = (Map<String, Object>) jsonObject.get("tabs");
    }
}
