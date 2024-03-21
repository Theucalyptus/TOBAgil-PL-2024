package jeu.peuples;

/**
 * Classe abstraite représentant un peuple.
 * Abstraite car non instantiable
 * mais mutualisation de code
 */
public abstract class Peuple {

    private String nom;
    private String description;
    private final TypesPeuples type;

    public Peuple(TypesPeuples peuple, String nom, String description) {
        this.type = peuple;
        this.nom = nom;
        this.description = description;
    }

    public String getNom() {
        return this.nom;
    }

    public String getDescription() {
        return this.description;
    }

    public TypesPeuples getTypePeuple() {
        return this.type;
    }
}