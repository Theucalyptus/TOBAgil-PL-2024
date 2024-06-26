package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import jeu.exceptions.OperationInterditeException;

/** Classe représentant un joueur. */
@SuppressWarnings("deprecation")
public class Joueur extends Observable {

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
        if (name == null || name.equals("") || pointsVictoire < 0) {
            throw new IllegalArgumentException("L'appel n'est pas correct.");
        }
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
        if (nouvelEtat == null) {
            throw new IllegalArgumentException("nouvelEtat ne doit pas être null.");
        }
        this.etat = nouvelEtat;
        this.notifierChangement();
    }

    /**Ajouter des points de victoire au joueur .
     *@param ajout de point de victoire ajouter
    */
    public void addPoints(int ajout) {
        if (ajout < 0) {
            throw new IllegalArgumentException("ajout ne doit pas être négatif.");
        }
        this.pointsVictoire = this.pointsVictoire + ajout;
        this.notifierChangement();
    }

    /**Enlever des points de victoire au joueur .
     *@param enleve de point de victoire.
    */
    public void subPoints(int enleve) {
        if (enleve < 0) {
            throw new IllegalArgumentException("enleve ne doit pas négatif.");
        }
        this.pointsVictoire = this.pointsVictoire - enleve;
        this.notifierChangement();
    }


    /** Changer de combinaison.
     *@param nouvelleCombinaison du joueur.
    */
    public void changerCombinaisonActive(Combinaison nouvelleCombinaison) {
        if (nouvelleCombinaison == null) {
            throw new IllegalArgumentException("nouvelleCombinaison "
                + "ne doit pas être null.");
        }
        if (this.combinaisonActive != null
                && !this.combinaisonActive.getDeclin()) {
            throw new OperationInterditeException(
                "Combinaison actuelle pas en déclin !");
        }
        if (this.combinaisonActive != null) {
            this.combinaisonsDeclins.add(this.combinaisonActive);
        }
        this.combinaisonActive = nouvelleCombinaison;

        this.notifierChangement();
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


    /**
     * Notifier les observers que le joueur a changé.
     */
    private void notifierChangement() {
        super.setChanged();
        super.notifyObservers();
        super.clearChanged();
    }
}
