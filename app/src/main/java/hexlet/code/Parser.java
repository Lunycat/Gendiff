package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class Parser {

    public static Map<String, Object> parse(File file) throws IOException {
        ObjectMapper objectMapper = null;

        if (file.getName().contains(".json")) {
            objectMapper = new ObjectMapper();
        } else if (file.getName().contains(".yaml") || file.getName().contains(".yml")) {
            objectMapper = new YAMLMapper();
        }

        Objects.requireNonNull(objectMapper);
        return objectMapper.readValue(file, new TypeReference<>() { });
    }
}
