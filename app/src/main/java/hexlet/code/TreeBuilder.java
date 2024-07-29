package hexlet.code;

import java.util.Map;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.ArrayList;

public class TreeBuilder {

    private static final int CAPACITY_OF_NODE = 1;

    public static List<Map<String, Object>> treeBuild(Set<String> keys,
                                                      Map<String, Object> data1, Map<String, Object> data2) {

        List<Map<String, Object>> tree = new ArrayList<>();

        keys.forEach(k -> {
            String value1 = String.valueOf(data1.get(k));
            String value2 = String.valueOf(data2.get(k));
            Map<String, Object> node = new LinkedHashMap<>(CAPACITY_OF_NODE);

            if (!data1.containsKey(k)) {
                node.put("key", k);
                node.put("type", "added");
                node.put("value", data2.get(k));
            } else if (!data2.containsKey(k)) {
                node.put("key", k);
                node.put("type", "deleted");
                node.put("value", data1.get(k));
            } else if (!value1.equals(value2)) {
                node.put("key", k);
                node.put("type", "changed");
                node.put("value1", data1.get(k));
                node.put("value2", data2.get(k));
            } else {
                node.put("key", k);
                node.put("type", "unchanged");
                node.put("value", data1.get(k));
            }

            tree.add(node);
        });

        return tree;
    }
}
