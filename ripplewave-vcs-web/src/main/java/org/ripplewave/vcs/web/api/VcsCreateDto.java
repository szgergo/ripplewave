package org.ripplewave.vcs.web.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.ripplewave.vcs.api.Vcs;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class VcsCreateDto {

    @NotNull
    private String name;

    private String description;

    @NotNull
    @JsonProperty("access_token")
    private String accessToken;

    public Vcs toDto() {
        return new Vcs(this.name, this.description, this.accessToken);
    }

    public static VcsCreateDto fromPojo(Vcs vcs) {
        return new VcsCreateDto(vcs.getName(), vcs.getDescription(), vcs.getAccessToken());
    }
}
