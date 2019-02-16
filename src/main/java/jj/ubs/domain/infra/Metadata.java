package jj.ubs.domain.infra;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "page",
    "page_count",
    "start_index",
    "end_index",
    "total_count",
    "current_page",
    "next_page"
})
public class Metadata {

    @JsonProperty("page")
    private String page;
    @JsonProperty("page_count")
    private Integer pageCount;
    @JsonProperty("start_index")
    private Integer startIndex;
    @JsonProperty("end_index")
    private Integer endIndex;
    @JsonProperty("total_count")
    private Integer totalCount;
    @JsonProperty("current_page")
    private String currentPage;
    @JsonProperty("next_page")
    private String nextPage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("page")
    public String getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(String page) {
        this.page = page;
    }

    @JsonProperty("page_count")
    public Integer getPageCount() {
        return pageCount;
    }

    @JsonProperty("page_count")
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    @JsonProperty("start_index")
    public Integer getStartIndex() {
        return startIndex;
    }

    @JsonProperty("start_index")
    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    @JsonProperty("end_index")
    public Integer getEndIndex() {
        return endIndex;
    }

    @JsonProperty("end_index")
    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    @JsonProperty("total_count")
    public Integer getTotalCount() {
        return totalCount;
    }

    @JsonProperty("total_count")
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @JsonProperty("current_page")
    public String getCurrentPage() {
        return currentPage;
    }

    @JsonProperty("current_page")
    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    @JsonProperty("next_page")
    public String getNextPage() {
        return nextPage;
    }

    @JsonProperty("next_page")
    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
