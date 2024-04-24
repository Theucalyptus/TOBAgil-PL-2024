package jeu.pouvoirs;

import jeu.Specialite;

/**
 * Classe abstraite représentant un pouvoir.
 * Abstraite car non instantiable
 * mais mutualisation de code
 */
public abstract class Pouvoir extends Specialite {

    /**Construire un pouvoir à partir de son nom, de sa description et de son nombre de pions supplémentaires.
     * @param nom Le nom du pouvoir.
     * @param description La description du pouvoir.
     * @param unitesup Le nombre de pions suplémentaires qu'apporte le pouvoir.
    */
    public Pouvoir(String nom, String description, int pions_sup) {
    	super(nom, description, pions_sup);
    }

}
