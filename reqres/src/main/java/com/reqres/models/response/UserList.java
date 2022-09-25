package com.reqres.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reqres.models.response.user.UserData;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class UserList {
    @JsonProperty
    private String page;
    @JsonProperty("per_page")
    private String perPage;
    @JsonProperty
    private String total;
    @JsonProperty("total_pages")
    private String totalPage;
    @JsonProperty
    private List<UserData> data;
}
