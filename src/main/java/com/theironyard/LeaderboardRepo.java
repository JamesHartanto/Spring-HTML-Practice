package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by JamesHartanto on 4/12/17.
 */
@Component
public class LeaderboardRepo {

    @Autowired
    JdbcTemplate template;

    // List leaderboard
    public List<Player> listTopTen(){
        return template.query("SELECT * FROM leaderboard ORDER BY score DESC limit 10",
                (rs, row) -> new Player(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("age"),
                        rs.getInt("score")
                )
        );
    }

    // Insert data into database
    public void insertData(Player player) throws SQLException {
        template.update("INSERT INTO leaderboard " +
                "(name,description,age,score) " +
                "VALUES " +
                "(?,?,?,?)",
                player.getName(),
                player.getDescription(),
                player.getAge(),
                player.getScore());
    }

    // Filter data from database
    public List<Player> filterData(String name) throws SQLException{
        return template.query("SELECT * from leaderboard " +
                        "WHERE lower(name)=lower(?) " +
                        "ORDER BY score DESC",
                new Object[]{name},
                (resultSet ,row) -> new Player(
                        resultSet.getInt("leaderboard_id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("age"),
                        resultSet.getInt("score")
                ));
    }
}
