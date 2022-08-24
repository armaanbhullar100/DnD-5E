package util;

import java.io.IOException;

import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

public class FileLoaderTest {
    @Test
    public void basicTest() throws IOException {
        FileLoader.loadResourceFile("items.json");
        System.out.println("works");
    }
}
