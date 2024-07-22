package hexlet.code.formatters;

import java.util.StringJoiner;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Collection;
import java.util.Map;

public final class Plain implements Formated {

    @Override
    public String format(List<LinkedHashMap<String, Object>> tree) {

        StringJoiner sj = new StringJoiner("\n");

        tree.forEach(m -> {
            String value1 = m.get("type").equals("changed")
                    ? formatValue(m.get("value1"))
                    : formatValue(m.get("value"));
            String value2 = m.get("type").equals("changed")
                    ? formatValue(m.get("value2"))
                    : formatValue(m.get("value"));
            Object key = m.get("key");

            if (m.get("type").equals("added")) {
                sj.add(String.format("Property '%s' was added with value: %s", key, value1));
            } else if (m.get("type").equals("deleted")) {
                sj.add(String.format("Property '%s' was removed", key));
            } else if (!String.valueOf(m.get("value1")).equals(String.valueOf(m.get("value2")))) {
                sj.add(String.format("Property '%s' was updated. From %s to %s", key, value1, value2));
            }
        });

        return sj.toString();
    }

    private static String formatValue(Object o) {
        String value;
        if (o instanceof String) {
            value = String.format("'%s'", o);
        } else if (o instanceof Collection<?> || o instanceof Map<?, ?>) {
            value = "[complex value]";
        } else {
            value = String.valueOf(o);
        }
        return value;
    }
}
