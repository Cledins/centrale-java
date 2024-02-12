package org.centrale.api;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<GameEntity, Integer> {
    @Query("SELECT COALESCE(MAX(g.id), 0) FROM GameEntity g")
    int findMaxGameEntityId();
}
