package hexlet.code;

import java.io.File;
import java.nio.file.Path;

public class TEST {
    public static void main(String[] args) {
        File file = Path.of("src/test/resources/file1.json").toFile();
        System.out.println(file.getName());
    }
}
