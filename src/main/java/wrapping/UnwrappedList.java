package wrapping;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UnwrappedList {
    public final String aString;
    public final List<ListItem> theList;

    @JsonCreator
    public UnwrappedList(@JsonProperty("aString") String aString,
                         @JsonProperty("uselessWrapper") ListWrapperClass theList) {
        this.aString = aString;
        this.theList = theList.theList;
    }

    public static class ListWrapperClass {
        public final List<ListItem> theList;

        @JsonCreator
        public ListWrapperClass(@JsonProperty("theList") List<ListItem> theList) {
            this.theList = theList;
        }
    }
}
