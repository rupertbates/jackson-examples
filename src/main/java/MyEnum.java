
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MyEnum {
    FIRST_VALUE("first-value"),
    SECOND_VALUE("second-value");

    private String jsonValue;

    MyEnum(String jsonValue){
        this.jsonValue = jsonValue;
    }

    @JsonCreator
    public static MyEnum forValue(String value) {
        for (MyEnum myEnum : MyEnum.values()) {
            if(myEnum.jsonValue.equals(value))
                return myEnum;
        }
        return null;
    }

    @JsonValue
    public String toValue() {
        return jsonValue;
    }
}