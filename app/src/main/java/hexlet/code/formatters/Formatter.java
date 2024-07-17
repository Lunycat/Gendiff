package hexlet.code.formatters;

import java.util.Map;
import java.util.Set;

public class Formatter {

    public static String choiceFormat(Set<String> keys, Map<String, Object> data1, Map<String, Object> data2,
                                      String format) {

        return switch (format) {
            case "stylish" -> new Stylish().format(keys, data1, data2);
            case "plain" -> new Plain().format(keys, data1, data2);
            case "json" -> new Json().format(keys, data1, data2);
            default -> throw new IllegalArgumentException("This format is not provided");
        };
    }
}
