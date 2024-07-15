package hexlet.code;

import java.util.Map;

public class Formater {

    public static String format(String key, Map<String, Object> data1, Map<String, Object> data2, String format) {

        String result;
        String value1 = String.valueOf(data1.get(key));
        String value2 = String.valueOf(data2.get(key));

        if (!data1.containsKey(key)) {
            result = String.format("  + %s: %s", key, value2);
        } else if (!data2.containsKey(key)) {
            result = String.format("  - %s: %s", key, value1);
        } else if (value1.equals(value2)) {
            result = String.format("    %s: %s", key, value1);
        } else {
            result = String.format("  - %s: %s\n", key, value1);
            result += String.format("  + %s: %s", key, value2);
        }

        return result;
    }
}
