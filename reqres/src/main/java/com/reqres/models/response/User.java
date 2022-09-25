package com.reqres.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reqres.models.response.user.UserData;
import com.reqres.models.response.common.Support;
import lombok.Getter;
import lombok.Setter;

@lombok.Data
@Setter
@Getter
public class User {
    @JsonProperty
    private UserData data;
    @JsonProperty
    private Support support;
}
