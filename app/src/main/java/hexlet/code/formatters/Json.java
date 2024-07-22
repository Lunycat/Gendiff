package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map;

public final class Json implements Formated {

    @Override
    public String format(Set<String> keys, Map<String, Object> data1, Map<String, Object> data2) {

        ObjectMapper objectMapper = new ObjectMapper();
        List<LinkedHashMap<String, Object>> result = new ArrayList<>();

        keys.forEach(k -> {
            String value1 = String.valueOf(data1.get(k));
            String value2 = String.valueOf(data2.get(k));
            LinkedHashMap<String, Object> node = new LinkedHashMap<>();

            if (!data1.containsKey(k)) {
                node.put("key", k);
                node.put("type", "added");
                node.put("value", data2.get(k));
            } else if (!data2.containsKey(k)) {
                node.put("key", k);
                node.put("type", "deleted");
                node.put("value", data1.get(k));
            } else if (!value1.equals(value2)) {
                node.put("key", k);
                node.put("type", "changed");
                node.put("value1", data1.get(k));
                node.put("value2", data2.get(k));
            } else {
                node.put("key", k);
                node.put("type", "unchanged");
                node.put("value", data1.get(k));
            }
            result.add(node);
        });

        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
