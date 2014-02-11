package polymorphism;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticleItem extends Item {
    public final String body;

    @JsonCreator
    public ArticleItem(@JsonProperty("body") String body) {
        this.body = body;
    }
}
