package jeu;

import jeu.peuples.Peuple;

public class EnsemblePions {
    /** Type de Peuple. */
    private Peuple peuple;

    /** Nombre de pions. */
    private int nombrePions;

    /** Constructeur à partir d'un peuple et d'un nombre de pions.
     * @param peuple Le Peuple dont fait partie l'ensemble de pions.
     * @param nombrePions Le nombre de pions dont l'ensemble de pions fait partie.
     */
    public EnsemblePions(Peuple peuple, int nombrePions) {
        this.peuple = peuple;
        this.nombrePions = nombrePions;
    }

    /** Obtenir le type de peuple de l'ensemble.
     * @return le peuple.
     */
    public Peuple getPeuple() {
        return this.peuple;
    }


    /** Obtenir le nombre de pions de l'ensemble.
     * @return le nombre de pions de l'ensemble.
     */
    public int getNombre() {
        return this.nombrePions;
    }

}
