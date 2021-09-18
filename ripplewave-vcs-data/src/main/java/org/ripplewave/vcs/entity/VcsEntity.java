package org.ripplewave.vcs.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.ripplewave.vcs.api.Vcs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vcs")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class VcsEntity {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String description;

    private String accessToken;

    public static VcsEntity fromDto(Vcs vcsCreateDto) {
        VcsEntity vcsEntity = new VcsEntity();
        vcsEntity.setAccessToken(vcsCreateDto.getAccessToken());
        vcsEntity.setDescription(vcsCreateDto.getDescription());
        vcsEntity.setName(vcsCreateDto.getName());
        return vcsEntity;
    }

    public Vcs toDto() {
        return new Vcs(this.getName(), this.description, this.accessToken);
    }

}
