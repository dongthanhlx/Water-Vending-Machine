package App;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Configration {
    private String configPath = "config/config.json";

    protected String dataPath;
    protected String sessionTimeout;
    protected int cartSize;

    public Configration() {
        // Read config.json
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(configPath)) {
            Object obj = jsonParser.parse(reader);
            String objectFormatString = obj.toString();
            JSONObject jsonObject = new JSONObject(objectFormatString);

            this.dataPath = (String) jsonObject.get("data_path");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDataPath() {
        return dataPath;
    }

    public String getSessionTimeout() {
        return sessionTimeout;
    }

    public int getCartSize() {
        return cartSize;
    }
}
