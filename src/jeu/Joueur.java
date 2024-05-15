package jeu;

import java.util.ArrayList;
import java.util.List;

import jeu.exceptions.OperationInterditeException;

/** Classe représentant un joueur. */
public class Joueur {

    /** Le Nom du joueur. */
    private String nom;

    /**Combinaisons du Joueur. */
    private List<Combinaison> combinaisonsDeclins;

    /** La combinaison active du joueur. */
    private Combinaison combinaisonActive;

    /** Le Nombre de point de victoire du joueur. */
    private int pointsVictoire;

    /** Le status du joueur. */
    private JoueurState etat;

    /**
     * Construire un Joueur.
     * @param name Le nom du Joueur.
     * @param pointsVictoire Le nombre de points de victoire initial.
     */
    public Joueur(String name, int pointsVictoire) {
        this.nom = name;
        this.pointsVictoire = pointsVictoire;
        this.combinaisonsDeclins = new ArrayList<>();
        this.etat = JoueurState.CHOIX_COMBINAISON;
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

    /**Obtenir l'état d'un joueur.
     * @return l'état dans lequel est le joueur.
     */
    public JoueurState getEtat() {
        return this.etat;
    }

    /**Définit l'état d'un joueur.
     * @param nouvelEtat le nouvel état du joueur.
     */
    public void setEtat(JoueurState nouvelEtat) {
        this.etat = nouvelEtat;
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
    public void changerCombinaisonActive(Combinaison nouvelleCombinaison) {
        if (this.combinaisonActive != null 
                && this.combinaisonActive.getDeclin() == false) {
            throw new OperationInterditeException(
                "Combinaison actuelle pas en déclin !");
        }
        if(this.combinaisonActive != null) {
            this.combinaisonsDeclins.add(this.combinaisonActive);
        }
        this.combinaisonActive = nouvelleCombinaison;
    }

    /**Obtenir la Combinaison du joueur.
     * @return la Combinaison du joueur.
     */
    public Combinaison getCombinaisonActive() {
        return this.combinaisonActive;
    }

    /**
     * Obtenir la liste des combinaisons en déclins du joueur.
     * @return la liste des combinaisons en déclins du joueur.
     */
    public List<Combinaison> getCombinaisonsDeclins() {
        return this.combinaisonsDeclins;
    }
}
