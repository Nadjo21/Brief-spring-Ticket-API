package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Learner;
import co.simplon.springticketapi.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LearnerRowMapper implements RowMapper<Learner> {

    //ROW MAPPER SERT A TRANSFORMER UNE LIGNE DE BDD EN UN OBJET -
    // (Visible dans RESPONSE BODY dans le SWAGGER)

    @Override
    public Learner mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Learner(resultSet.getLong("id"), resultSet.getString("name"));
    }

}
