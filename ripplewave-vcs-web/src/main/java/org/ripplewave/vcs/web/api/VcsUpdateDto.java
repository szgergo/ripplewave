package org.ripplewave.vcs.web.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class VcsUpdateDto {

    @NotNull
    private Long id;

    private String name;

    private String description;

    @JsonProperty("access_token")
    private String accessToken;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAccessToken() {
        return accessToken;
    }

}
