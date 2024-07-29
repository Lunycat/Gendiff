package hexlet.code.formatters;

import java.util.Map;
import java.util.List;

public interface Formated {
    String format(List<Map<String, Object>> tree);
}
