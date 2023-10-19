package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String p, Map<String, String> attributes) {
        super(p, attributes);
    }

    @Override
    public String toString() {
        return tagToString();
    }
}
// END
