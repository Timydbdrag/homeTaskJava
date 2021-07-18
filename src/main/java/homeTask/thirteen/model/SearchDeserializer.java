package homeTask.thirteen.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class SearchDeserializer extends JsonDeserializer<SearchData> {

    @Override
    public SearchData deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);

        Integer ns = node.get("ns").asInt();
        String title = node.get("title").asText();
        Long pageid = node.get("pageid").asLong();
        Long size = node.get("size").asLong();
        Long wordcount = node.get("wordcount").asLong();
        String snippet = node.get("snippet").asText();
        String timestamp = node.get("timestamp").asText();

        SearchData searchData = new SearchData();
        searchData.setNs(ns);
        searchData.setTitle(title);
        searchData.setPageid(pageid);
        searchData.setSize(size);
        searchData.setWordcount(wordcount);
        searchData.setSnippet(snippet);
        searchData.setTimestamp(timestamp);
        return searchData;
    }
}
