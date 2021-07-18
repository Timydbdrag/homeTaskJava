package homeTask.thirteen.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import homeTask.thirteen.ApiConstant;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Query {

    private Searchinfo searchinfo;
    @JsonProperty("search")
    private List<SearchData> search;

    public Searchinfo getSearchinfo() {
        return searchinfo;
    }

    public void setSearchinfo(Searchinfo searchinfo) {
        this.searchinfo = searchinfo;
    }

    public List<SearchData> getSearch() {
        return search;
    }

    public void setSearch(List<SearchData> search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ApiConstant.TO_STRING_BUILDER_STYLE)
                .append("searchinfo", searchinfo)
                .append("search", search)
                .toString();
    }

}
