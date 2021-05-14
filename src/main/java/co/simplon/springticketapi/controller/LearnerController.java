package co.simplon.springticketapi.controller;


import co.simplon.springticketapi.dao.Dao;
import co.simplon.springticketapi.dao.LearnerDao;
import co.simplon.springticketapi.dao.TicketDao;
import co.simplon.springticketapi.model.Learner;
import co.simplon.springticketapi.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.management.openmbean.CompositeData;
import java.util.List;

@RequestMapping("/api/learners")
@RestController
public class LearnerController {

    //JDBC permet d'établir à la BDD  la connexion - il faut juste le déclarer( plus rapide que la méthode classique Resultset)
    private JdbcTemplate jdbcTemplate;

    private final LearnerDao learnerDao;

    public LearnerController(LearnerDao learnerDao) {
        this.learnerDao = learnerDao;
    }


//Gérer les apprenants dans la base de données

    // OK - Recuperer la liste de tous les apprenannts
    @GetMapping
    public List<Learner> getLearners(Learner learner) {
        return learnerDao.getAll();
    }

    //OK - Ajouter un nouvel apprenant dans la liste

    @PostMapping
    public Learner postLearner(@RequestBody Learner learner) {
        return learnerDao.post(learner);
    }

    //Supprimer un apprenant de la liste
    @DeleteMapping("/{id}")
    public void deleteLearner(@PathVariable Long id) {

   learnerDao.delete(id);
        System.out.println(id);
    }

}

