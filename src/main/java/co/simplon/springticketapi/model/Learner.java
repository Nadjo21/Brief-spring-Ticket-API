package co.simplon.springticketapi.model;

public class Learner {
    // je crée mon objet LEARNER avec attributs , constructeur , accesseurs
    private Long id;
    private String name;

    public Learner(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Learner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
