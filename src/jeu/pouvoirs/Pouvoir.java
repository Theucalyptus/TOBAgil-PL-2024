package jeu.pouvoirs;

/**
 * Classe abstraite représentant un pouvoir.
 * Abstraite car non instantiable
 * mais mutualisation de code
 */
public abstract class Pouvoir {

    private String nom;
    private String description;
    private final TypesPouvoirs typePouvoir; // sera défini par le constructeur appelé par une sous-classe

    public Pouvoir(TypesPouvoirs pouv, String nom, String description) {
        this.typePouvoir = pouv;
        this.nom = nom;
        this.description = description;
    }

    public String getNom() {
        return this.nom;
    }

    public String getDescription() {
        return this.description;
    }

    public TypesPouvoirs getTypePouvoir() {
        return this.typePouvoir;
    }
}