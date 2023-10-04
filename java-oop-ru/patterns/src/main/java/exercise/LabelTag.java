package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    String tagText;
    InputTag inputTag;

    public LabelTag(String tagText, TagInterface inputTag) {
        this.tagText = tagText;
        this.inputTag = (InputTag) inputTag;
    }

    @Override
    public String render() {
        return "<label>" + tagText + inputTag.render() + "</label>";
    }
}
// END
