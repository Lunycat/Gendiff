package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

public class Differ {

    public static String generate(Path filepath1, Path filepath2) throws IOException {

        StringJoiner sj = new StringJoiner("\n", "{\n", "\n}");
        File file1 = filepath1.toFile().getAbsoluteFile();
        File file2 = filepath2.toFile().getAbsoluteFile();
        Map<String, Object> mapOfFile1 = getData(file1);
        Map<String, Object> mapOfFile2 = getData(file2);
        Set<String> keys = new TreeSet<>(mapOfFile1.keySet());
        keys.addAll(mapOfFile2.keySet());

        keys.forEach(k -> sj.add(stringFormat(k, mapOfFile1, mapOfFile2)));

        return sj.toString();
    }

    static Map<String, Object> getData(File file) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, new TypeReference<>() { });
    }

    private static String stringFormat(String key, Map<String, Object> data1, Map<String, Object> data2) {

        String result;

        if (!data1.containsKey(key)) {
            result = String.format("  + %s: %s", key, data2.get(key));
        } else if (!data2.containsKey(key)) {
            result = String.format("  - %s: %s", key, data1.get(key));
        } else if (data1.get(key).equals(data2.get(key))) {
            result = String.format("    %s: %s", key, data1.get(key));
        } else {
            result = String.format("  - %s: %s\n", key, data1.get(key));
            result += String.format("  + %s: %s", key, data2.get(key));
        }

        return result;
    }
}
