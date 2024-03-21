package jeu;

/**
 * Classe abstraite représentant un pouvoir.
 * Abstraite car non instantiable
 * mais mutualisation de code
 */
abstract class Peuple {

    private String nom;
    private String description;
    private final TypesPeuples type;

    public Peuple(TypesPeuples pouv, String nom, String description) {
        this.type = pouv;
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