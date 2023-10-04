package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    String tagText;
    Object inputTag;

    public LabelTag(String tagText, Object inputTag) {
        this.tagText = tagText;
        this.inputTag = inputTag;
    }

    @Override
    public String render() {
        return "<label>" + tagText + "<input type=\"submit\" value=\"Save\"></label>";
    }
}
// END
