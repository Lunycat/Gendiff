package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.Map;
import java.util.Set;

public abstract class Formatter {

    public static Formatter choiceFormat(String format) {

        Formatter formatter = null;

        if (format.equals("stylish")) {
            formatter = new Stylish();
        } else if (format.equals("plain")) {
            formatter = new Plain();
        }

        return formatter;
    }

    public abstract String format(Set<String> keys, Map<String, Object> data1, Map<String, Object> data2);
}
