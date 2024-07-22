package hexlet.code.formatters;

import java.util.Map;
import java.util.Set;

public interface Formated {
    String format(Set<String> keys, Map<String, Object> data1, Map<String, Object> data2);
}
