package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DifferTest {

    @Test
    public void test() throws IOException {
        String expected1 = Files.readString(Paths.get("src/test/resources/stylish"));
        String expected2 = Files.readString(Paths.get("src/test/resources/plain"));
        expected1 = expected1.replace("\r", "");
        expected2 = expected2.replace("\r", "");

        String actual1 = Differ.generate(Paths.get("src/test/resources/file1.json"),
                Paths.get("src/test/resources/file2.yaml"));
        String actual2 = Differ.generate(Paths.get("src/test/resources/file1.yaml"),
                Paths.get("src/test/resources/file2.json"), "plain");

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertThrows(IllegalArgumentException.class, () ->
                Differ.generate(Paths.get("src/test/resources/file1.yaml"),
                Paths.get("src/test/resources/file2.json"), "dasdasdsa"));
    }
}
