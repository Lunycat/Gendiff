package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(File file) throws IOException {
        ObjectMapper objectMapper;

        if (file.getName().contains(".json")) {
            objectMapper = new ObjectMapper();
        } else {
            objectMapper = new YAMLMapper();
        }

        return objectMapper.readValue(file, new TypeReference<>() { });
    }
}
