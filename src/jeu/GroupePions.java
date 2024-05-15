package jeu;

import jeu.Combinaison;
import jeu.peuples.*;
import jeu.pouvoirs.*;

public class GroupePions {
    /** Type de Combinaison. */
    private Combinaison combinaison;

    /** Nombre de pions. */
    private int nombrePions;

    /** Case */
    private Case laCase;

    /** Constructeur à partir d'un peuple et d'un nombre de pions.
     * @param combinaison La combinaison dont fait partie l'ensemble de pions.
     * @param nombrePions Le nombre de pions dont l'ensemble de pions fait partie.
     */
    public GroupePions(Combinaison combinaison, int nombrePions) {
        this.combinaison = combinaison;
        this.nombrePions = nombrePions;
    }

    /** Obtenir le type de combinaison du groupe.
     * @return la combinaison.
     */
    public Combinaison getCombinaison() {
        return this.combinaison;
    }

    public Peuple getPeuple() {
        return this.combinaison.getPeuple();
    }

    public Pouvoir getPouvoir() {
        return this.combinaison.getPouvoir();
    }


    /** Obtenir le nombre de pions du groupe.
     * @return le nombre de pions du groupe.
     */
    public int getNombre() {
        return this.nombrePions;
    }

    /** Obtenir la case où se trouve les pions.
     * @return la case.
     */
    public Case getCase() {
        return this.laCase;
    }

    public void setNombre(int newNombrePions) {
        this.nombrePions = newNombrePions;
    }


    public void setCase(Case newCase) {
        this.laCase = newCase;
    }

}
