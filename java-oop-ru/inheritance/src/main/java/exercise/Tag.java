package exercise;

import java.util.List;
import java.util.Map;

// BEGIN
public class Tag {
    String p;
    Map<String, String> attributes;
    String textParagraph;
    List<Tag> tags;

    public Tag(String p, Map<String, String> attributes, String textParagraph, List<Tag> tags) {
        this.p = p;
        this.attributes = attributes;
        this.textParagraph = textParagraph;
        this.tags = tags;
    }

    public Tag(String p, Map<String, String> attributes) {
        this.p = p;
        this.attributes = attributes;
    }

    public String getP() {
        return p;
    }

    public String tagToString() {
        StringBuilder toStringBuilder = new StringBuilder("<" + p);
        for (Map.Entry<String, String> element : attributes.entrySet()) {
            toStringBuilder.append(" ")
                    .append(element.getKey()).append("=\"")
                    .append(element.getValue()).append("\"");
        }
        return toStringBuilder.append(">").toString();
    }
}
// END
