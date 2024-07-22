package hexlet.code;

import hexlet.code.formatters.Formatter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {

    public static String generate(String filepath1, String filepath2) throws IOException {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        File file1 = Paths.get(filepath1).toAbsolutePath().normalize().toFile();
        File file2 = Paths.get(filepath2).toAbsolutePath().normalize().toFile();

        Map<String, Object> mapOfFile1 = Parser.parse(file1);
        Map<String, Object> mapOfFile2 = Parser.parse(file2);

        Set<String> keys = new TreeSet<>(mapOfFile1.keySet());
        keys.addAll(mapOfFile2.keySet());

        return Formatter.choiceFormat(TreeBuilder.treeBuild(keys, mapOfFile1, mapOfFile2), format);
    }
}
