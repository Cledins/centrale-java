package org.centrale.api;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "game")
public class GameEntity {
    @Id
    public Integer id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



}
