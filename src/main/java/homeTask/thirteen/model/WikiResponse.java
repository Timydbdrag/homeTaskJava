package homeTask.thirteen.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import homeTask.thirteen.ApiConstant;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiResponse {
    private String batchcomplete;
    @JsonProperty("continue")
    private Continue continue_;
    private Query query;

    public String getBatchcomplete() {
        return batchcomplete;
    }

    public void setBatchcomplete(String batchcomplete) {
        this.batchcomplete = batchcomplete;
    }

    public Continue getContinue_() {
        return continue_;
    }

    public void setContinue_(Continue continue_) {
        this.continue_ = continue_;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ApiConstant.TO_STRING_BUILDER_STYLE)
                .append("batchcomplete", batchcomplete)
                .append("continue", continue_)
                .append("query", query)
                .toString();
    }
}
