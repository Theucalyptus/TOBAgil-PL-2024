package jeu.pouvoirs;
import jeu.Specialite;

/**
 * Classe abstraite représentant un pouvoir.
 * Abstraite car non instantiable
 * mais mutualisation de code
 */
public abstract class Pouvoir extends Specialite {

    /**Le type du pouvoir. */
    private final TypesPouvoirs typePouvoir;

    /**Construire un pouvoir à partir de son nom, de sa description et
     * de son nombre de pions supplémentaires.
     * @param type Le type du Pouvoir.
     * @param nom Le nom du pouvoir.
     * @param description La description du pouvoir.
     * @param pionsSup Le nombre de pions suplémentaires qu'apporte le pouvoir.
    */
    public Pouvoir(TypesPouvoirs type, String nom, String description, int pionsSup) {
    	super(nom, description, pionsSup);
        this.typePouvoir = type;
    }

    /**
     * Obtenir le type du pouvoir.
     * @return Le type du pouvoir.
     */
    public TypesPouvoirs getType() {
        return this.typePouvoir;
    }
}
