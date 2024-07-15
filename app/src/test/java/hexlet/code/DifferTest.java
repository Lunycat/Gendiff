package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DifferTest {

    @Test
    public void JSONTest() throws IOException {
        String expected = Files.readString(Paths.get("src/test/resources/stylish"));
        String actual = Differ.generate(Paths.get("src/test/resources/file1.json"),
                Paths.get("src/test/resources/file2.json"));
        expected = expected.replace("\r", "");

        assertEquals(expected, actual);
    }

    @Test
    public void YAMLTest() throws IOException {
        String expected = Files.readString(Paths.get("src/test/resources/stylish"));
        String actual = Differ.generate(Paths.get("src/test/resources/file1.yaml"),
                Paths.get("src/test/resources/file2.yaml"));
        expected = expected.replace("\r", "");

        assertEquals(expected, actual);
    }
}
