package dnd.e.util;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import util.FileLoader;

public class FileLoaderTest {
    @Test
    public void basicTest() throws IOException {
        FileLoader.loadResourceFile("items.json");
    }
}
