package polymorphism;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentArticleItem extends ArticleItem {
    public final String contributor;

    @JsonCreator
    public CommentArticleItem(@JsonProperty("body") String body,
                              @JsonProperty("contributor") String contributor) {
        super(body);
        this.contributor = contributor;
    }
}
