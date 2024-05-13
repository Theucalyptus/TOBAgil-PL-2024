package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Observer;

import javax.swing.GroupLayout.Group;

import jeu.exceptions.JoueurDejaDansLaPartieException;
import jeu.exceptions.NombreJoueurIncorrectException;
import jeu.exceptions.PartieEnCoursException;
import jeu.exceptions.PartiePleineException;

import observables.JoueurCourantObs;
import observables.NombreTourObs;

/**
 * Classe représentant une partie de jeu.
 */

@SuppressWarnings("deprecation")
public class JeuReel implements Jeu {

    // atributs

    /** La liste de joueurs. */
    private List<Joueur> joueurs;

    /** Le joueur courant. */
    private Joueur joueurCourant;

    /** Iterateur sur les joueurs. */
    private ListIterator<Joueur> joueursIter;

    /** Le numéro du tour actuel dans la partie. */
    private int noTour;

    /** Le nombre de tour total qui devra être fait dans la partie. */
    private int nbToursTotals;

    /** Le nombre de Joueur de la partie. */
    private int nombreJoueurs;

    /** Le plateau. */
    private Monde monde;              // Le plateau du monde

    /** Indique si la partie est encore (pas commencée ou pas finies). */
    private Boolean enCours = false;

    /** Permet de notifier lorsque le joueur courant change. */
    private JoueurCourantObs joueurCourantObs;

    /** Permet de notifier lorsque le numero du tour change. */
    private NombreTourObs nbTourObs;

    // Constructeur

    /**Construire un Jeu Réel.
     * @param nbJoueurs Le nombre de Joueur de la partie.
    */
    public JeuReel(int nbJoueurs) {
        this(nbJoueurs, new Monde(nbJoueurs));
    }

    /**Construire un Jeu Reel. */
    public JeuReel() {
        this(0, null);
    }


    private JeuReel(int nbJoueurs, Monde leMonde) {
        this.joueurs = new ArrayList<>();
        this.monde = leMonde;
        this.enCours = false;
        this.nbToursTotals = 0;
        this.noTour = 1;
        this.joueurCourant = null;
        this.joueursIter = null;
        this.joueurCourantObs = new JoueurCourantObs();
        this.nbTourObs = new NombreTourObs();
        this.nombreJoueurs = nbJoueurs;
    }


    // requetes


    @Override
    public Monde getMonde() {
        return this.monde;
    }

    @Override
    public Joueur getJoueurCourant() {
        return this.joueurCourant;
    }

    @Override
    public int getNumeroTour() {
        return this.noTour;
    }

    /**
     * Obtenir le nombre de joueurs dans la partie.
     * @return Le nombre de Joueur.
     */
    public int getNombreJoueur() {
        return this.nombreJoueurs;
    }

    /*
    /**
     * Obtenir la liste des Joueurs.
     * @return La liste des Joueurs.
     *\/
    public List<Joueur> getJoueurs() {
        return this.joueurs;
    } */

    @Override
    public void addJoueurCourantObserver(Observer obs) {
        this.joueurCourantObs.addObserver(obs);
    }

    @Override
    public void addNbTourObserver(Observer obs) {
        this.nbTourObs.addObserver(obs);
    }


    @Override
    public int getNombreTourTotal() {
        return this.nbToursTotals;
    }

    /**
     * Obtenir si la partie est en cours.
     * @return Si la partie est en cours.
     */
    public boolean estEnCoursDePartie() {
        return this.enCours;
    }

    // commandes

    @Override
    public void setNumeroTour(int newNoTour) {
        this.noTour = newNoTour;
        this.nbTourObs.notifyNombreTour();
    }

    /**
     * Permet de mettre à jour le joueur Courant.
     * @param joueurCourant le joueur qui sera le nouveau joueur courant.
     * @throws IllegalArgumentException Quand le joueur Courant est un pointeur null.
     * @throws JoeurExterieurException Quand le joueur n'est pas dans la liste des
     * joueurs de la partie.
     */
    public void setJoueurCourant(Joueur joueurCourant) {
        this.joueurCourant = joueurCourant;
        this.joueurCourantObs.notifyJoueurCourant();
    }

    @Override
    public void setMonde(Monde leNouveauMonde) {
        this.monde = leNouveauMonde;
    }

    /**Retirer tous les Joueurs de la listes des joueurs. */
    public void reinitialiserJoueurs() {
        this.joueurs = new ArrayList<>();
    }

    /**
     * Changer la valeur du champs enCours par la valeur en argument.
     * @param enCours La nouvelle valeur de enCours.
     */
    public void setEnCours(boolean enCours) {
        this.enCours = enCours;
    }

    /**Actualiser le nombre de tour de la partie en fonction du
     * nombre de joueur dans la partie.
     * @throws NombreJoueurIncorrectException Si le Nombre de Joueur n'est pas conforme.
     */
    private void majNombreToursTotals() {
        switch (this.nombreJoueurs) {
            case 2:
                this.nbToursTotals = 10;
                break;
            case 3:
                this.nbToursTotals = 9;
                break;
            case 4 | 5:
                this.nbToursTotals = 8;
                break;
            default:
                throw new NombreJoueurIncorrectException();
        }
    }


    /**Ajouter un joueur dans la liste de joueurs s'il y a de la place
     * Sinon throw PartiePleineException.
     * @param joueur Le joueur qu l'on souhaite ajouté à la liste.
     * @throws PartiePleineException Quand on tente d'ajouter un joueur
     * dans une partie pleine (5 Joueurs).
     * @throws PartieEnCoursException Quand on tente d'ajouter un joueur
     * en pleine partie.
     * @throws IllegalArgumentException Quand le Joueur est une poignée null.
     */
    @Override
    public void ajouterJoueur(Joueur joueur) {
        if (joueur == null) {
            throw new IllegalArgumentException("Le joueur ne doit pas être nul.");
        } else if (this.joueurs.contains(joueur)) {
            throw new JoueurDejaDansLaPartieException();
        } else if (this.getNombreJoueur() == 5) {
            throw new PartiePleineException();
        }
        this.joueurs.add(joueur);
        this.nombreJoueurs++;
    }


    /**Simuler une partie.
     * @throws PartieEnCoursException Quand on essaye de lancer une
     * partie alors qu'il y en a une déjà en cours.
     */
    @Override
    public void lancerPartie() {
        if (this.enCours) {
            throw new PartieEnCoursException();
        }
        this.enCours = true;
        this.majNombreToursTotals();
        this.setNumeroTour(1);
        this.joueursIter = this.joueurs.listIterator();
        this.setJoueurCourant(this.joueursIter.next());
    }

    /** Ajouter le nombre de points de victoire au joueur. */
    private void ajouterPtsVictoire() {
        int nb_pts = 0;
        int pts_bonus = 0;
        Combinaison combinaison_joueur = this.joueurCourant.getCombinaisonActive(); //la combinaison du joueur courant
        pts_bonus = combinaison_joueur.finTour(); //obtenir le nombre de points bonus
        nb_pts = combinaison_joueur.nombre_groupes_pions() + pts_bonus;
        this.joueurCourant.addPoints(nb_pts);
    }

    /**
     * Permet de passer au tour suivant.
     */
    @Override
    public void passerTour() {
        if(this.enCours) {
            // Actions de fin de tour
            this.ajouterPtsVictoire();
            //this.joueurCourant.addPoints(4);


            // Passage au tour suivant
            if (this.joueursIter.hasNext()) {
                this.setJoueurCourant(this.joueursIter.next());
            } else {
                this.joueursIter = this.joueurs.listIterator();
                this.setNumeroTour(this.getNumeroTour() + 1);
                this.setJoueurCourant(this.joueursIter.next());
            }
            if (this.getNumeroTour() > this.getNombreTourTotal()) {
                this.enCours = false;
                System.out.println("");
            }
        } else {
            System.out.println("Partie non-commencé ou terminée. Abandon !");
        }
    }

    @Override
    public void attaquerCase(Case maCase) {
        //checker si la case est
        //if (maCase.estAtteignable()) {
            if (maCase.getPrenable()) { //Boolean et pas boolean
                Combinaison combinaisonActive = joueurCourant.getCombinaisonActive();
                int diff = 0; // combinaisonActive.getNbPionsEnMain() - getNombreAttaquantNecessaire();
                if(diff >= 0) {
                    GroupePions newGroupe = new GroupePions(combinaisonActive, 1);
                    maCase.setNewpions(newGroupe);
                    combinaisonActive.addGroupe(newGroupe);
                    combinaisonActive.setNbPionsEnMain(diff);
                } else if (diff >= -3){
                    System.out.println("Pas assez de pions !");
                    //lancer dé
                } else {
                    System.out.println("Pas assez de pions !");
                    //exception conquête impossible pas assez de pions
                }

            } else {
                System.out.println("Case non prenable");
                //exception case non prenable (effet de pouvoir) (imprenable + paix).
            }
        //} else {
            //exception case non atteignable (pas de pions sur une case voisine)
        //} 
    }
}
