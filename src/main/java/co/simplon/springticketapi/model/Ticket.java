package co.simplon.springticketapi.model;

import java.time.LocalDateTime;

public class Ticket {
    private Long id;
    private LocalDateTime date;
    private String description;
    //ajout de l'attribut learneridx pour la question 2
    private int learneridx;
    //ajout de l'attribut boolean pour la question 3 pour changer le statut du ticket avec le @PutRequest
private boolean solved;




    public Ticket(LocalDateTime localDateTime) {
        this.date = localDateTime;
    }

    public Ticket(Long id, LocalDateTime date, String description, int learneridx,boolean solved) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.learneridx=learneridx;
        this.solved=solved;
    }

    /*
        //question 2 a jout d'un nouveau contructeur incluant le boolean
        public Ticket(Long id, LocalDateTime date, String description, boolean solved) {
            this.id = id;
            this.date = date;
            this.description = description;
            //this.solved = solved;
        }
    */
    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    //j'ajoute l'accesseur au learneridx
    public int getLearneridx() {
        return learneridx;
    }



    //pour la question 3 , ajout du setter pour modifier le statut du ticket avec le PutRequest

    public boolean getSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = true;
    }





    /* methode ok
    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }*/


    /*
    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", learneridx=" + learneridx +
                '}';
    }*/

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", learneridx=" + learneridx +
                ", solved=" + solved +
                '}';
    }

}

