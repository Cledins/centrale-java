package org.centrale.api;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<PlayerEntity, Integer> {
    PlayerEntity findByName(String name);

    @Query("SELECT COALESCE(MAX(p.id), 0) FROM PlayerEntity p")
    int findMaxPlayerEntityId();
}
