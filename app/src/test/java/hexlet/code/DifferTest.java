package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DifferTest {

    @Test
    public void stylishTest() throws IOException {
        String expected = Files.readString(Paths.get("src/test/resources/stylish"));
        String actual = Differ.generate(Paths.get("src/test/resources/file1.json"),
                Paths.get("src/test/resources/file2.json"));
        expected = expected.replace("\r", "");

        assertEquals(expected, actual);
    }
}
