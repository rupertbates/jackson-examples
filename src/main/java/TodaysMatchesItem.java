import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TodaysMatchesItem extends Item {
    public final String teams;

    @JsonCreator
    public TodaysMatchesItem(@JsonProperty("teams") String teams) {
        this.teams = teams;
    }
}
