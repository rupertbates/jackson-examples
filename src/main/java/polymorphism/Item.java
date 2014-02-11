package polymorphism;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ArticleItem.class, name = "article"),
        @JsonSubTypes.Type(value = TodaysMatchesItem.class, name = "todays-matches")
})
public abstract class Item {

}
