package hexlet.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

public class Differ {

    public static String generate(Path filepath1, Path filepath2, String format) throws IOException {

        StringJoiner sj = new StringJoiner("\n", "{\n", "\n}");
        File file1 = filepath1.toFile().getAbsoluteFile();
        File file2 = filepath2.toFile().getAbsoluteFile();
        Map<String, Object> mapOfFile1 = Parser.parse(file1);
        Map<String, Object> mapOfFile2 = Parser.parse(file2);
        Set<String> keys = new TreeSet<>(mapOfFile1.keySet());
        keys.addAll(mapOfFile2.keySet());

        for (String key : keys) {
            sj.add(Formater.format(key, mapOfFile1, mapOfFile2, format));
        }

        //keys.forEach(k -> sj.add(Formater.format(k, mapOfFile1, mapOfFile2, format)));

        return sj.toString();
    }

    public static String generate(Path filepath1, Path filepath2) throws IOException {
        return generate(filepath1, filepath2, "stylish");
    }
}
