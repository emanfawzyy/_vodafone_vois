package Data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    public static JSONObject parseJson(String jsonFilePath) {
        JSONParser Parser = new JSONParser();
        FileReader reader = null;
        String mainPath = "";
        String currentDirectory = "C:\\Users\\ELKHOLY\\Downloads\\test\\src\\test\\java\\";

        try {
            reader = new FileReader(mainPath + jsonFilePath);
        } catch (FileNotFoundException e) {
            System.out.println("No file");
            e.printStackTrace();
        }

        JSONObject object = null;
        try {
            object = (JSONObject) Parser.parse(reader);
        } catch (IOException | ParseException e) {
            System.out.println("Failed");
            e.printStackTrace();
        }
        return object;
    }
}
