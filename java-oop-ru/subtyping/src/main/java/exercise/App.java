package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> map = storage.toMap();
        Set<Entry<String, String>> entries = map.entrySet();
        for (Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            storage.set(value, key);
            storage.unset(key);
        }
    }
}
// END
