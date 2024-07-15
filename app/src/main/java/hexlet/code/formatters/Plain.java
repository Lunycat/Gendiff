package hexlet.code.formatters;

import hexlet.code.Formatter;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

public class Plain extends Formatter {

    @Override
    public String format(Set<String> keys, Map<String, Object> data1, Map<String, Object> data2) {

        StringJoiner sj = new StringJoiner("\n");

        keys.forEach(k -> {
            String value1 = isObject(k) ? "[complex value]" : String.valueOf(data1.get(k));
            String value2 = isObject(k) ? "[complex value]" : String.valueOf(data2.get(k));

            if (!data1.containsKey(k)) {
                sj.add(String.format("Property '%s' was added with value: '%s'", k, value2));
            } else if (!data2.containsKey(k)) {
                sj.add(String.format("  - %s: %s", k, value1));
            } else if (value1.equals(value2)) {
                sj.add(String.format("    %s: %s", k, value1));
            } else {
                sj.add(String.format("  - %s: %s", k, value1));
                sj.add(String.format("  + %s: %s", k, value2));
            }
        });

        return sj.toString();
    }

    private static boolean isObject(Object o) {
        return o == null || o instanceof Arrays;
    }
}
