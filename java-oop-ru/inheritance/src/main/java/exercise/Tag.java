package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private String name;
    private Map<String, String> attributes;
    private String content;

    public Tag(String name, Map<String, String> attributes, String content) {
        this.name = name;
        this.attributes = attributes;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String getContent() {
        return content;
    }

    public String getAttributesAsString() {
        return attributes.entrySet().stream()
            .map(entry -> " " + entry.getKey() + "=\"" + entry.getValue() + "\"")
            .collect(Collectors.joining());
    }
}
// END
