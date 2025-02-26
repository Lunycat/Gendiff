package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String choiceFormat(List<Map<String, Object>> tree, String format) {

        return switch (format) {
            case "stylish" -> new Stylish().format(tree);
            case "plain" -> new Plain().format(tree);
            case "json" -> new Json().format(tree);
            default -> throw new IllegalArgumentException("This format is not provided");
        };
    }
}
