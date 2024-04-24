package jeu.peuples;

import jeu.Specialite;

/**
 * Classe abstraite représentant un pouvoir.
 * Abstraite car non instantiable
 * mais mutualisation de code
 */
public abstract class Peuple extends Specialite {

    /**Construire un peuple à partir de son nom, de sa description et de son nombre de pions supplémentaires.
     * @param nom Le nom du peuple.
     * @param description La description du peuple.
     * @param unitesup Le nombre de pions suplémentaires qu'apporte le peuple.
    */
    public Peuple(String nom, String description, int pions_sup) {
    	super(nom, description, pions_sup);
    }

}