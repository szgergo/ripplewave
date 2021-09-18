package org.ripplewave.vcs.api;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Vcs {

    private final String name;

    private final String description;

    private final String accessToken;
}
