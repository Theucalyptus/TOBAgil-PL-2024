package jeu;

import jeu.peuples.Peuple;

public class EnsemblePionsImpl implements EnsemblePions {
    /** Type de Peuple. */
    private Peuple peuple;

    /** Nombre de pions. */
    private int nombre_pions;

    /** Constructeur à partir d'un peuple et d'un nombre de pions. */
    public EnsemblePionsImpl(Peuple peuple, int nombre_pions) {
        this.peuple = peuple;
        this.nombre_pions = nombre_pions;
    } 

    /** Obtenir le type de peuple de l'ensemble.
     * @return le peuple 
     */
    public Peuple getPeuple() {
        return this.peuple;
    } 

    /**Donner l'état de l'unité
     * @return L'état de l'unité : VIVANT, ENDECLIN, MORT
     */


    /** Obtenir le nombre de pions de l'ensemble.
     * @return le nombre de pions de l'ensemble 
     */
    public int getNombre() {
        return this.nombre_pions;
    } 

}