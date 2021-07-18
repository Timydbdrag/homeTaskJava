package homeTask.thirteen.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class SearchSerializer extends JsonSerializer<SearchData> {

    @Override
    public void serialize(SearchData searchData, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        gen.writeString(searchData.getSnippet());
        gen.writeString(searchData.getTitle());
        gen.writeString(searchData.getTimestamp());
        gen.writeNumber(searchData.getNs());
        gen.writeNumber(searchData.getSize());
        gen.writeNumber(searchData.getPageid());
        gen.writeNumber(searchData.getWordcount());
        gen.writeEndArray();
    }
}
