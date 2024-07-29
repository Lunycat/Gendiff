package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.List;

public final class Json implements Formated {

    @Override
    public String format(List<Map<String, Object>> tree) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(tree);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
