package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Ticket;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TicketRowMapper implements RowMapper<Ticket> {

    //ROW MAPPER SERT A TRANSFORMER UNE LIGNE DE BDD EN UN OBJET -
    // (Visible dans RESPONSE BODY dans le SWAGGER)

   @Override
    public Ticket mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Ticket(resultSet.getLong("id"), resultSet.getTimestamp("date").toLocalDateTime(),resultSet.getString("description"),resultSet.getInt("learneridx"), resultSet.getBoolean("solved"));

    }

}
