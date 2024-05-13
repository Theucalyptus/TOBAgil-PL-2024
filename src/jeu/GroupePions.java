package jeu;

/**Classe qui représente un groupe de pions. Un groupe de pions est un
 * nombre de pions d'une certaine combinaison Peuple-Pouvoir. */
public class GroupePions {
    /** Type de Combinaison. */
    private Combinaison combinaison;

    /** Nombre de pions. */
    private int nombrePions;

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


    /** Obtenir le nombre de pions du groupe.
     * @return le nombre de pions du groupe.
     */
    public int getNombre() {
        return this.nombrePions;
    }

}
