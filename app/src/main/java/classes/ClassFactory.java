package classes;

import java.io.IOException;

// import org.json.JSONObject;

import classes.classList.*;
import util.FileLoader;

public class ClassFactory {
    String jsonString;

    public ClassFactory() throws IOException {
        try {
            this.jsonString = FileLoader.loadResourceFile("classes.json");
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public Class createClass(String classType) {
        // JSONObject newItem;
        // try {
        //     newItem = new JSONObject(jsonString).getJSONObject(classType.toLowerCase());
        // } catch (Exception e) {
        //     // If class cannot be found, return error
        //     return null;
        // }

        if (classType.equals("Barbarian")) {
            return new Barbarian(classType, 0, null, null, null, null, null, null);
        } else {
            return null;
        }
    }
}
