package com.reqres.models.response.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Support {
    @JsonProperty
    private String url;
    @JsonProperty
    private String text;
}
