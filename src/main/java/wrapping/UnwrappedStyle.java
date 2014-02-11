package wrapping;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("style")
public class UnwrappedStyle {
    public final String primaryColour;
    public final String secondaryColour;
    public final String overlayColour;

    @JsonCreator
    public UnwrappedStyle(@JsonProperty("primaryColour") String primaryColour,
                          @JsonProperty("secondaryColour") String secondaryColour,
                          @JsonProperty("overlayColour") String overlayColour) {
        this.primaryColour = primaryColour;
        this.secondaryColour = secondaryColour;
        this.overlayColour = overlayColour;
    }
}
