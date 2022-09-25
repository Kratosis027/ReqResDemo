package com.reqres.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reqres.models.response.resource.ResourceData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceList extends BasicList {
    @JsonProperty
    private ResourceData data;

    public ResourceList(String page, String perPage, String total, String totalPage, ResourceData data) {
        super(page, perPage, total, totalPage);
        this.data = data;
    }
}
