package org.centrale.api.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class PlayerDBService {
    final DataSource dataSource;

    public PlayerDBService(DataSource dataSource) {this.dataSource = dataSource;}

    public void addPlayer(Integer id, String name){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("INSERT INTO players values (" + id + ",'"+name+"')");
    }
}
