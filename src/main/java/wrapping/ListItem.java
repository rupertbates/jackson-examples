package wrapping;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ListItem {
    public final String title;

    @JsonCreator
    public ListItem(@JsonProperty("title") String title) {
        this.title = title;
    }
}
