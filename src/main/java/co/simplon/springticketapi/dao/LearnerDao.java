package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Learner;
import co.simplon.springticketapi.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LearnerDao implements Dao<Learner> {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Learner> learnerRowMapper;


    public LearnerDao(JdbcTemplate jdbcTemplate, RowMapper<Learner> learnerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.learnerRowMapper = learnerRowMapper;
    }

    //Methode getAll cree pour afficher la liste des apprenants et insertion en BDD
    @Override
    public List<Learner> getAll() {
         return jdbcTemplate.query("select * from learner ", learnerRowMapper);
    }

    //methode post cree contenant l'instruction SQL pour ajout d'un nouvel apprenant en BDD
    public Learner post(Learner learner) {
        jdbcTemplate.execute("INSERT INTO learner (name) VALUES ('" + learner.getName() + "')");
        return learner;
    }

   // methode delete cree contenant l'instruction SQL pour a supprimer un apprenant de la BDD
    //ici , id dans la requet correspond a l'attribut id dans la methode void delete juste au dessus

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM learner where id ="+ id);


    }


    @Override
    public void save(Learner learner) {
        // A vous de jouer
    }

    @Override
    public Learner get(Long id) {
        // A vous de jouer
        return null;
    }




}



