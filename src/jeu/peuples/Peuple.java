package jeu.peuples;

/**
 * Classe abstraite représentant un peuple.
 * Abstraite car non instantiable
 * mais mutualisation de code
 */
public abstract class Peuple {

    /** Le Nom du peuple. */
    private final String nom;

    /** La description du peuple, la notice de ses capacité.*/
    private final String description;

    /** L'éthnie du peuple. */
    private final TypesPeuples type;

    /** Le nombre d'unité de base d'un peuple sans le compte que rajoute le pouvoir */
    private final int uniteclass;

    // Constructeur

    public Peuple(TypesPeuples peuple, String nom, String description, int nombre_unite) {
        this.type = peuple;
        this.nom = nom;
        this.description = description;
        this.uniteclass = nombre_unite;
    }

    // requêtes

    /**
     * Donner le nom du peuple.
     * @return Le nom du peuple
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Donner la description du peuple.
     * @return La description du peuple, ses capacités.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Donner le type de peuple du peuple.
     * @return Le type du peuple.
     */
    public TypesPeuples getTypePeuple() {
        return this.type;
    }

    /**
     * Donner le nombre d'unite du peuple sans le nombre du pouvoir.
     * @return Le nombre d'unité du peuple sans le nombre du pouvoir.
     */
    public int getUniteClasse() {
        return this.uniteclass;
    }
}