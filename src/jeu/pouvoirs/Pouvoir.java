package jeu.pouvoirs;

/**
 * Classe abstraite représentant un pouvoir.
 * Abstraite car non instantiable
 * mais mutualisation de code
 */
public abstract class Pouvoir {

    /**Le nom du pouvoir. */
    private String nom;

    /**La description du pouvoir. */
    private String description;

    /**Le type du pouvoir. */
    private final TypesPouvoirs typePouvoir; // sera défini par le constructeur appelé par une sous-classe

    private int unitesup;

    /**Construire un pouvoir à partir de son type, son nom, sa description et son nombre d'unité supplémentaire.
     * @param pouv Le type de pouvoir.
     * @param nom Le nom du pouvoir.
     * @param description La description du pouvoir.
     * @param unitesup Le nombre d'unité suplémentaire qu'offre le pouvoir en complément.
    */
    public Pouvoir(TypesPouvoirs pouv, String nom, String description, int unitesup) {
        this.typePouvoir = pouv;
        this.nom = nom;
        this.description = description;
        this.unitesup = unitesup;
    }


    // getteurs

    /**
     * Donner le nom de la classe.
     * @return Le nom de la Classe.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Donner la description de la classe.
     * @return La description de la classe.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Donner le type de pouvoir du poivoir.
     * @return Le type de Pouvoir du pouvoir.
     */
    public TypesPouvoirs getTypePouvoir() {
        return this.typePouvoir;
    }

    /**
     * Donner le nombre d'unité supplémentaire que procure ce pouvoir.
     * @return Le nombre d'unité supplémentaire.
     */
    public int getUniteSup() {
        return this.unitesup;
    }


}
