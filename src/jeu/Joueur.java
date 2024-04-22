package jeu;

public class Joueur {
    
    private String nom;
    private Ensemble<Combinaison> combinaison;
    private int pts_victoire;

    public Joueur(String name, Ensemble<Combinaison> combinaison, int pts_vitoire) {
        this.nom = name;
        this.pts_victoire = pts_vitoire;
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
        return this.pts_victoire;
    }

    /**Ajouter des points de victoire au joueur .
     *@param ajout de point de victoire ajouter
    */
    public void addPoints(int ajout) {
        this.pts_victoire = this.pts_victoire + ajout;
    }

    /**Enlever des points de victoire au joueur .
     *@param enleve de point de victoire 
    */
    public void subPoints(int enleve) {
        this.pts_victoire = this.pts_victoire - enleve;
    }

    
    /**Changer de combinaison
     *@param nouvelle_combinaison du joueur 
    */
    public void setCombinaisons(Ensemble<Combinaison> nouvelle_combinaison) {
        this.combinaison = nouvelle_combinaison;
    }
}
