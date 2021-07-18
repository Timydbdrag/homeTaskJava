package homeTask.thirteen.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import homeTask.thirteen.ApiConstant;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonDeserialize(using = SearchDeserializer.class)
@JsonSerialize(using = SearchSerializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchData {

    private Integer ns;
    private String title;
    private Long pageid;
    private Long size;
    private Long wordcount;
    private String snippet;
    private String timestamp;

    public Integer getNs() {
        return ns;
    }

    public void setNs(Integer ns) {
        this.ns = ns;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPageid() {
        return pageid;
    }

    public void setPageid(Long pageid) {
        this.pageid = pageid;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getWordcount() {
        return wordcount;
    }

    public void setWordcount(Long wordcount) {
        this.wordcount = wordcount;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ApiConstant.TO_STRING_BUILDER_STYLE)
                .append("ns", ns)
                .append("title", title)
                .append("pageid", pageid)
                .append("size", size)
                .append("wordcount", wordcount)
                .append("snippet", snippet)
                .append("timestamp", timestamp)
                .toString();
    }
}
