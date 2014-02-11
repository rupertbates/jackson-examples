import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.junit.Assert;
import org.junit.Test;
import polymorphism.ArticleItem;
import polymorphism.Item;
import polymorphism.TodaysMatchesItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestSerialisation {
    @Test
    public void testDeserialiseClassHierarchy() throws IOException {
        String json = "[{\"type\":\"article\",\"body\":\"Body text\"},{\"type\":\"todays-matches\",\"teams\":\"Man U v Chelsea\"}]";
        ObjectMapper mapper = new ObjectMapper();
        List<Item> items = mapper.readValue(json, TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Item.class));
        Assert.assertTrue(items.size() == 2);
    }

    @Test
    public void testSerialiseClassHierarchy() throws IOException {
        Item[] items = new Item[2];
        items[0] = new ArticleItem("Body text");
        items[1] = new TodaysMatchesItem("Man U v Chelsea");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(items);
        System.out.println(json);
        assertNotNull(json);
    }

    @Test
    public void testSerialiseEnum() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(MyEnum.FIRST_VALUE);
        System.out.println(json);
        assertEquals("\"first-value\"", json);
    }

    @Test
    public void testDeserialiseEnum() throws IOException {
        String json = "\"second-value\"";
        ObjectMapper mapper = new ObjectMapper();
        MyEnum myEnum = mapper.readValue(json, MyEnum.class);
        Assert.assertEquals(MyEnum.SECOND_VALUE, myEnum);
    }



}
