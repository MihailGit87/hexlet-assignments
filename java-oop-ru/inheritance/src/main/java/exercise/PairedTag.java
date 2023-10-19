package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag  {

    public PairedTag(String p, Map<String, String> attributes, String textParagraph, List<Tag> tags) {
        super(p, attributes, textParagraph, tags);
    }

    @Override
    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder(tagToString() + textParagraph);
        for (Tag child : tags) {
            toStringBuilder.append(child.tagToString());
        }
        return toStringBuilder.append("</").append(getP()).append(">").toString();
    }
}
// END
