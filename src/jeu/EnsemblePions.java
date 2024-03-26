package jeu;

import jeu.peuples.Peuple;

public interface EnsemblePions {
    
    Peuple getPeuple();

    /**Donner l'état de l'unité
     * @return L'état de l'unité : VIVANT, ENDECLIN, MORT
     */
    int getNombre();

}