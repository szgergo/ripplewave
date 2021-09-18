package org.ripplewave.vcs.repository;

import org.ripplewave.vcs.entity.VcsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VcsRepository extends CrudRepository<VcsEntity, Long> {
}
