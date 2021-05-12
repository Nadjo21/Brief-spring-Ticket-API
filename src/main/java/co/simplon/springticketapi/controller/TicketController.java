package co.simplon.springticketapi.controller;

import co.simplon.springticketapi.dao.TicketDao;
import co.simplon.springticketapi.dao.TicketRowMapper;
import co.simplon.springticketapi.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/tickets")
@RestController
public class TicketController {


    //JDBC permet d'établir à la BDD  la connexion - il faut juste le déclarer( plus rapide que la méthode classique Resultset)
    private JdbcTemplate jdbcTemplate;

    private final TicketDao ticketDao;

    public TicketController(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    // QUESTION 1 OK- l'annotation ci dessous me permet d'ajouter un ticket ( que j'insère ensuite dans la BDD avec la requête JDBC dans TicketDAO)
    @PostMapping
    public Ticket postTicket(@RequestBody Ticket ticket) {
        System.out.println(ticket);
        return ticketDao.post(ticket);
    }


    //QUESTION 2 OK -Lister les tickets en cours (ceux qui ne sont pas résolus)
    @GetMapping
    public List<Ticket> getAllTickets() {
        System.out.println();
        return ticketDao.getAll();
    }


//code d'origine
    /*@GetMapping
    public List<Ticket> getAllTickets() {
        return ticketDao.getAll();
    }*/


//QUESTION 3 -Mettre à jour des tickets (une fois que l'on a repondu a la question- le statut "solved" doit ensuite passer de false a true dans la bdd)
    @PutMapping
    public List<Ticket> ticketChangeStatus(@RequestBody Ticket ticketstatus){
        ticketstatus.setSolved(true);
        return ticketDao.getAll();


    }


    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable Long id) {
        return ticketDao.get(id);
    }


}

