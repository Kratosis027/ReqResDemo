package com.reqres.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Setter
@Getter
@RequiredArgsConstructor
public class BasicList {
    @JsonProperty
    private String page;
    @JsonProperty("per_page")
    private String perPage;
    @JsonProperty
    private String total;
    @JsonProperty("total_page")
    private String totalPage;

    public BasicList(String page, String perPage, String total, String totalPage) {
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPage = totalPage;
    }
}
