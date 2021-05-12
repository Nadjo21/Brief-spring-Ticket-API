package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketDao implements Dao<Ticket> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Ticket> ticketRowMapper;

    public TicketDao(JdbcTemplate jdbcTemplate, RowMapper<Ticket> ticketRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.ticketRowMapper = ticketRowMapper;
    }

    // QUESTION 1- OK -requête pour créer un nouveau ticket dans la BDD
    public Ticket post(Ticket ticket) {
        jdbcTemplate.execute("INSERT INTO ticket (date, description, learneridx) VALUES ('" + ticket.getDate() + "','" + ticket.getDescription()+"','" + ticket.getLearneridx()+"')");
        return ticket;
    }

    //QUESTION 2 OK -requête pour récuperer l'ensemble des tickets en cours (PAS ENCORE TRAITES)

    @Override
    public List<Ticket> getAll() {
        return jdbcTemplate.query("select * from ticket where solved = false", ticketRowMapper);
    }

    //code d'origine
//    @Override
//    public List<Ticket> getAll() {
//        return jdbcTemplate.query("select * from ticket", ticketRowMapper);
//    }



    // QUESTION 3- POur la requet PUT , mettre à jour le statut dans la BDD ( passer la colonne solved de false a true )

    @Override
    public void save(Ticket ticket) {
        jdbcTemplate.execute("UPDATE ticket (solved) VALUES ('" + ticket.getSolved() +"')");

    }

    @Override
    public Ticket get(Long id) {
        return jdbcTemplate.queryForObject("select * from ticket where id = ?", ticketRowMapper, id);
    }

    @Override
    public void delete(Long id) {
        // A vous de jouer
    }



}
