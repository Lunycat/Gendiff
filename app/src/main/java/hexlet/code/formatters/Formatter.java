package hexlet.code.formatters;

import java.util.Map;
import java.util.Set;

public class Formatter {

    public static String choiceFormat(Set<String> keys, Map<String, Object> data1, Map<String, Object> data2,
                                      String format) {

        if (format.equals("stylish")) {
            return new Stylish().format(keys, data1, data2);
        } else if (format.equals("plain")) {
            return new Plain().format(keys, data1, data2);
        } else {
            throw new IllegalArgumentException("This format is not provided");
        }
    }
}
