package jeu.peuples;

import jeu.Specialite;

/**
 * Classe abstraite représentant un pouvoir.
 * Abstraite car non instantiable
 * mais mutualisation de code
 */
public abstract class Peuple extends Specialite {

    /**Le Type du Pueple, utile pour l'affichage. */
    private TypesPeuples typePeuple;

    /**Construire un peuple à partir de son nom, de sa description et de
     * son nombre de pions supplémentaires.
     * @param type Le type du peuple.
     * @param nom Le nom du peuple.
     * @param description La description du peuple.
     * @param pionsSup Le nombre de pions suplémentaires qu'apporte le peuple.
    */
    public Peuple(TypesPeuples type, String nom, String description, int pionsSup) {
    	super(nom, description, pionsSup);
        this.typePeuple = type;
    }

    /**
     * Obtenir le type du peuple.
     * @return Le type du peuple.
     */
    public TypesPeuples getType() {
        return this.typePeuple;
    }

}
