package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private final Map<String, String> storage;

    private final String path;

    public FileKV(String path, Map<String, String> storage) {
        this.path = path;
        this.storage = storage;
        Utils.writeFile(path, Utils.serialize(storage));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> data = Utils.deserialize(Utils.readFile(path));
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> data = Utils.deserialize(Utils.readFile(path));
        data.put(key, value);
        Utils.writeFile(path, Utils.serialize(data));
    }

    @Override
    public void unset(String key) {
        Map<String, String> data = Utils.deserialize(Utils.readFile(path));
        data.remove(key);
        Utils.writeFile(path, Utils.serialize(data));
    }

   @Override
    public Map<String, String> toMap() {
        return Utils.deserialize(Utils.readFile(path));
    }
}
// END
