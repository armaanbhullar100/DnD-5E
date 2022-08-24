package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileLoader {
    /**
     * Loads a resource file given a certain path that is relative to resources/
     * for example `/dungeons/maze.json`.  Will add a `/` prefix to path if it's not specified.
     * 
     * @param path Relative to resources/ will add an implicit `/` prefix if not given.
     * @return The textual content of the given file.
     * @throws IOException If the file doesn't exist / some other IO exception.
     */
    public static String loadResourceFile(String path) throws IOException {
        if (!path.startsWith("/"))
            path = "/" + path;
        try {
            return new String(Files.readAllBytes(Path.of(FileLoader.class.getResource(path).toURI())));
        } catch (URISyntaxException e) {
            throw new FileNotFoundException(path);
        }
    }
    
}