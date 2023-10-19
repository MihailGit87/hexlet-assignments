package exercise;

import java.util.List;
import java.util.stream.Collectors;
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
}
// END
