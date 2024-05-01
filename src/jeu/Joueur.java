package jeu;


/** Classe représentant un joueur. */
public class Joueur {

    /** Le Nom du joueur. */
    private String nom;

    /**Combinaisons du Joueur. */
    //private Ensemble<Combinaison> combinaison;
    private Combinaison combinaison;

    /** Le Nombre de point de victoire du joueur. */
    private int pointsVictoire;

    /**
     * Construire un Joueur.
     * @param name Le nom du Joueur.
     * @param pointsVictoire Le nombre de points de victoire initial.
     */
    public Joueur(String name, int pointsVictoire) {
        this.nom = name;
        this.pointsVictoire = pointsVictoire;
    }

    /**Obtenir le nom du joueur .
     *@return nom du joueur
    */
    public String getNom() {
        return this.nom;
    }

    /**Obtenir le nombre de point de victoire du joueur .
     *@return nombre de victoire du joueur
    */
    public int getPoints() {
        return this.pointsVictoire;
    }

    /**Ajouter des points de victoire au joueur .
     *@param ajout de point de victoire ajouter
    */
    public void addPoints(int ajout) {
        this.pointsVictoire = this.pointsVictoire + ajout;
    }

    /**Enlever des points de victoire au joueur .
     *@param enleve de point de victoire.
    */
    public void subPoints(int enleve) {
        this.pointsVictoire = this.pointsVictoire - enleve;
    }


    /** Changer de combinaison.
     *@param nouvelleCombinaison du joueur.
    */
    //public void setCombinaisons(Ensemble<Combinaison> nouvelleCombinaison) {
    public void setCombinaison(Combinaison nouvelleCombinaison) {
        this.combinaison = nouvelleCombinaison;
    }

    /**Obtenir la Combinaison du joueur.
     * @return la Combinaison du joueur.
     */
    public Combinaison getCombinaison() {
        return this.combinaison;
    }
}
