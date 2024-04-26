package jeu;

import jeu.peuples.Peuple;

/**interface qui représente un pion. */
public interface EnsemblePions {

    /** Donner le peuple du pion.
     *
     * @return Le peuple.
     */
    Peuple getPeuple();

    /** Donner le Nombre de pion.
     *
     * @return le Nombre.
     */
    int getNombre();

}
