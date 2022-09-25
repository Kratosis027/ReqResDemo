package com.reqres.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reqres.models.response.common.Support;
import com.reqres.models.response.resource.ResourceData;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Resource {
    @JsonProperty
    private ResourceData data;
    @JsonProperty
    private Support support;
}
