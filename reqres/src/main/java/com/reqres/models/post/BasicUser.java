package com.reqres.models.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class BasicUser {
    @JsonProperty
    private String name;
    @JsonProperty
    private String job;
    @JsonProperty
    private String id;
    @JsonProperty
    private String updatedAt;
    @JsonProperty
    private String createdAt;
}
