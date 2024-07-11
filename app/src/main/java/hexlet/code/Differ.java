package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;


import static hexlet.code.App.filepath1;
import static hexlet.code.App.filepath2;

public class Differ {

    public static String generate() throws IOException {

        StringJoiner sj = new StringJoiner("\n");

        Map<String, Object> mapOfFile1 = getData(filepath1);
        Map<String, Object> mapOfFile2 = getData(filepath2);

        Set<String> keys = new TreeSet<>(mapOfFile1.keySet());
        keys.addAll(mapOfFile2.keySet());

        keys.forEach(k -> sj.add(stringFormat(k, mapOfFile1, mapOfFile2)));

        return sj.toString();
    }

    static Map<String, Object> getData(Path path) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(path.toFile(), new TypeReference<>() { });
    }

    private static String stringFormat(String key, Map<String, Object> data1, Map<String, Object> data2) {

        String result;

        if (!data1.containsKey(key)) {
            result = String.format("+ %s: %s", key, data2.get(key));
        } else if (!data2.containsKey(key)) {
            result = String.format("- %s: %s", key, data1.get(key));
        } else if (data1.get(key).equals(data2.get(key))) {
            result = String.format("  %s: %s", key, data1.get(key));
        } else {
            result = String.format("- %s: %s", key, data1.get(key));
            result += String.format("\n+ %s: %s", key, data2.get(key));
        }

        return result;
    }
}
