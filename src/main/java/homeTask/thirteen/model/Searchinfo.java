package homeTask.thirteen.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import homeTask.thirteen.ApiConstant;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Searchinfo {
    private Long totalhits;

    public Long getTotalhits() {
        return totalhits;
    }

    public void setTotalhits(Long totalhits) {
        this.totalhits = totalhits;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ApiConstant.TO_STRING_BUILDER_STYLE)
                .append("totalhits", totalhits)
                .toString();
    }
}
