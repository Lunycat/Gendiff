package hexlet.code.formatters;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringJoiner;

public final class Stylish implements Formated {

    @Override
    public String format(List<LinkedHashMap<String, Object>> tree) {

        StringJoiner sj = new StringJoiner("\n", "{\n", "\n}");

        tree.forEach(m -> {
            Object value1 = m.get("type").equals("changed")
                    ? m.get("value1")
                    : m.get("value");
            Object value2 = m.get("type").equals("changed")
                    ? m.get("value2")
                    : m.get("value");
            Object key = m.get("key");

            if (m.get("type").equals("added")) {
                sj.add(String.format("  + %s: %s", key, value1));
            } else if (m.get("type").equals("deleted")) {
                sj.add(String.format("  - %s: %s", key, value1));
            } else if (m.get("type").equals("unchanged")) {
                sj.add(String.format("    %s: %s", key, value1));
            } else {
                sj.add(String.format("  - %s: %s", key, value1));
                sj.add(String.format("  + %s: %s", key, value2));
            }
        });

        return sj.toString();
    }
}
