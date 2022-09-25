package com.reqres.models.response.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ResourceData {
    @JsonProperty
    private int id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String year;
    @JsonProperty
    private String color;
    @JsonProperty("pantone_value")
    private String pantoneValue;
}
