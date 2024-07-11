package hexlet.code;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;
import static hexlet.code.App.filepath1;
import static hexlet.code.App.filepath2;

public class Differ {

    public static String generate() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> mapOfFile1 = objectMapper
                .readValue((JsonParser) filepath1, new TypeReference<>(){});
        Map<String, Object> mapOfFile2 = objectMapper
                .readValue((JsonParser) filepath2, new TypeReference<>(){});
        StringJoiner sj = new StringJoiner("\n");

        System.out.println(mapOfFile1.keySet());
        System.out.println(mapOfFile2.keySet());

        Set<String> keys = new TreeSet<>(mapOfFile1.keySet());
        keys.addAll(mapOfFile2.keySet());

        keys.forEach(k -> {
            if (!mapOfFile1.containsKey(k)) {
                sj.add(String.format("- %s: %s", k, mapOfFile1.get(k)));
            }
        });

        return null;
    }

}
