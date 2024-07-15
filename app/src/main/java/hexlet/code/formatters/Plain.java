package hexlet.code.formatters;

import hexlet.code.Formatter;

import java.util.*;

public class Plain extends Formatter {

    @Override
    public String format(Set<String> keys, Map<String, Object> data1, Map<String, Object> data2) {

        StringJoiner sj = new StringJoiner("\n");

        keys.forEach(k -> {
            String value1 = formatValue(data1.get(k));
            String value2 = formatValue(data2.get(k));

            if (!data1.containsKey(k)) {
                sj.add(String.format("Property '%s' was added with value: %s", k, value2));
            } else if (!data2.containsKey(k)) {
                sj.add(String.format("Property '%s' was removed", k));
            } else if (!value1.equals(value2)) {
                sj.add(String.format("Property '%s' was updated. From %s to %s", k, value1, value2));
            }
        });

        return sj.toString();
    }

    private static String formatValue(Object o) {
        String value;
        if (o instanceof String) {
            value = String.format("'%s'", o);
        } else if (o instanceof Collection<?> || o instanceof Map<?,?>) {
            value = "[complex value]";
        } else {
            value = String.valueOf(o);
        }
        return value;
    }
}