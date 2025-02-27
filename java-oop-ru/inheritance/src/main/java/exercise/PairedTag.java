package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String content, List<Tag> children) {
        super(name, attributes, content);
        this.children = children;
    }

    private String getChildrenAsString() {
        return children.stream()
            .map(Tag::toString)
            .collect(Collectors.joining());
    }

    public String toString() {
        return "<" + getName() + getAttributesAsString() + ">" + getContent() + getChildrenAsString() + "</" + getName() + ">";
    }
}
// END
