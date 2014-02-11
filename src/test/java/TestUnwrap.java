import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import wrapping.UnwrappedList;
import wrapping.UnwrappedStyle;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestUnwrap {
    @Test
    public void testUnwrapStyle() throws IOException {
        String json = "{\n" +
                "    \"style\": {\n" +
                "        \"primaryColour\": \"#005689\",\n" +
                "        \"secondaryColour\": \"#4bc6df\",\n" +
                "        \"overlayColour\": \"#183f5d\"\n" +
                "    }\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        UnwrappedStyle style = mapper.readValue(json, UnwrappedStyle.class);
        assertEquals(style.primaryColour, "#005689");
    }

    @Test
    public void testUnwrapList() throws IOException {
        String json = "{\n" +
                "    \"aString\" : \"a string\",\n" +
                "    \"uselessWrapper\" : {\n" +
                "        \"theList\" : [\n" +
                "            {\"title\" : \"one\"},\n" +
                "            {\"title\" : \"two\"}\n" +
                "        ]\n" +
                "    }\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        UnwrappedList list = mapper.readValue(json, UnwrappedList.class);
        assertEquals(2, list.theList.size());

    }
}
