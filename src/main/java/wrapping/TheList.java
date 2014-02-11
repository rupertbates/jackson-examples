package wrapping;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TheList {
    public final List<ListItem> theList;

    @JsonCreator
    public TheList(@JsonProperty("theList") List<ListItem> theList) {
        this.theList = theList;
    }
}
