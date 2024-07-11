package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static hexlet.code.App.filepath1;
import static hexlet.code.App.filepath2;

public class Differ {

    public static String generate() throws IOException {
        System.out.println(Files.readAllLines(filepath1));
        return null;
    }
}
