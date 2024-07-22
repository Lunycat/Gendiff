package hexlet.code.formatters;

import java.util.LinkedHashMap;
import java.util.List;

public interface Formated {
    String format(List<LinkedHashMap<String, Object>> tree);
}
