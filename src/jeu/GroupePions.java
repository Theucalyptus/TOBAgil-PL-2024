package jeu;

import jeu.peuples.Peuple;
import jeu.pouvoirs.Pouvoir;

public class GroupePions {
    /** Type de Combinaison. */
    private Combinaison combinaison;

    /** Nombre de pions. */
    private int nombrePions;

    /** La case ou le groupe de Point se trouve. */
    private Case laCase;

    /** Constructeur à partir d'un peuple et d'un nombre de pions.
     * @param combinaison La combinaison dont fait partie l'ensemble de pions.
     * @param nombrePions Le nombre de pions dont l'ensemble de pions fait partie.
     */
    public GroupePions(Combinaison combinaison, int nombrePions) {
        if (combinaison == null || nombrePions < 0) {
            throw new IllegalArgumentException("L'appel n'est pas conforme.");
        }
        this.combinaison = combinaison;
        this.nombrePions = nombrePions;
    }

    /** Obtenir le type de combinaison du groupe.
     * @return la combinaison.
     */
    public Combinaison getCombinaison() {
        return this.combinaison;
    }

    /**
     * Obtenir le peuple du groupe de pion.
     * @return Le peuple du groupe de pion.
     */
    public Peuple getPeuple() {
        return this.combinaison.getPeuple();
    }

    /**
     * Obtenir le pouvoir du groupe de pion.
     * @return Le pouvoir du groupe de pion.
     */
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

    /**
     * Changer la valeur du nombre de Pions.
     * @param newNombrePions La nouvelle valeur du nombre de pions.
     */
    public void setNombre(int newNombrePions) {
        if (newNombrePions < 0) {
            throw new IllegalArgumentException("Le nombre de pion "
                + "ne peut pas être positif.");
        }
        this.nombrePions = newNombrePions;
    }

    /**
     * Changer la case sur laquelle se trouve les pions.
     * @param newCase la nouvelle case du groupe de pions.
     */
    public void setCase(Case newCase) {
        if (newCase == null) {
            throw new IllegalArgumentException("La nouvelle case ne peut pas être null");
        }
        this.laCase = newCase;
    }

}
