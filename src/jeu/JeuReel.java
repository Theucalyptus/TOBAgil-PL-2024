package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Observer;

import jeu.exceptions.JoueurDejaDansLaPartieException;
import jeu.exceptions.NombreJoueurIncorrectException;
import jeu.exceptions.PartieEnCoursException;
import jeu.exceptions.PartiePasEnCoursException;
import jeu.exceptions.PartiePleineException;

/**
 * Classe représentant une partie de jeu.
 */
@SuppressWarnings("deprecation")
public class JeuReel extends Observable implements Jeu {

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
    private Monde monde;

    /** La pioche. */
    private Pioche pioche;

    /** Indique le statut de la partie. */
    private JeuState etat;

    /** Observable du joueur courant. */
    private JoueurCourantObs joueurCourantObs;

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
        if (nbJoueurs < 0 || nbJoueurs == 1 || nbJoueurs > 5) {
            throw new IllegalArgumentException("L'appel au constructeur "
                + "n'est pas valide.");
        }
        this.joueurs = new ArrayList<>();
        this.monde = leMonde;
        this.nbToursTotals = 0;
        this.noTour = 1;
        this.joueurCourant = null;
        this.joueursIter = null;
        this.nombreJoueurs = nbJoueurs;
        this.etat = JeuState.PAS_COMMENCEE;
        this.joueurCourantObs = new JoueurCourantObs(this);
        this.pioche = new Pioche();
    }


    // requetes


    @Override
    public Monde getMonde() {
        return this.monde;
    }

    @Override
    public Pioche getPioche() {
        return this.pioche;
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
    public int getNombreTourTotal() {
        return this.nbToursTotals;
    }

    /**
     * Obtenir si la partie est en cours.
     * @return Si la partie est en cours.
     */
    public boolean estEnCoursDePartie() {
        return this.etat == JeuState.EN_COURS;
    }

    // commandes

    @Override
    public void setNumeroTour(int newNoTour) {
        this.noTour = newNoTour;
        this.notifierModifs();
    }

    @Override
    public void ajouterObservateur(Observer obs) {
        if (obs == null) {
            throw new IllegalArgumentException("obs ne doit pas être null.");
        }
        super.addObserver(obs);
    }

    @Override
    public void ajouterObservateurJoueurCourant(Observer obs) {
        if (obs == null) {
            throw new IllegalArgumentException("obs ne doit pas être null.");
        }
        this.joueurCourantObs.addObserver(obs);
    }

    /**
     * Permet de mettre à jour le joueur Courant.
     * @param joueurCourant le joueur qui sera le nouveau joueur courant.
     * @throws IllegalArgumentException Quand le joueur Courant est un pointeur null.
     * @throws JoeurExterieurException Quand le joueur n'est pas dans la liste des
     * joueurs de la partie.
     */
    public void setJoueurCourant(Joueur joueurCourant) {
        if (joueurCourant == null) {
            throw new IllegalArgumentException("joueurCourant ne doit pas être null.");
        } else if (!this.joueurs.contains(joueurCourant)) {
            throw new IllegalArgumentException("joueurCourant doit "
                + "participer à la partie.");
        }
        this.joueurCourantObs.detacher();
        this.joueurCourant = joueurCourant;
        this.joueurCourantObs.attacher();
        this.joueurCourantObs.notifierChangement();
    }

    @Override
    public void setMonde(Monde leNouveauMonde) {
        if (leNouveauMonde == null) {
            throw new IllegalArgumentException("leNouveauMonde ne doit pas être null.");
        }
        this.monde = leNouveauMonde;
    }

    /**Retirer tous les Joueurs de la listes des joueurs. */
    public void reinitialiserJoueurs() {
        this.joueurs = new ArrayList<>();
    }

    /**
     * Changer l'état du jeu.
     * @param newEtat Le nouvel état.
     */
    private void setEtat(JeuState newEtat) {
        if (newEtat == null) {
            throw new IllegalArgumentException("newEtat ne doit pas être null.");
        }
        this.etat = newEtat;
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
        if (this.etat == JeuState.EN_COURS || this.etat == JeuState.TERMINEE) {
            throw new PartieEnCoursException();
        }

        this.setEtat(JeuState.EN_COURS);
        this.joueursIter = this.joueurs.listIterator();
        this.setJoueurCourant(this.joueursIter.next()); // la position est importante !
        this.majNombreToursTotals();
        this.setNumeroTour(1);
        this.notifierModifs();
    }

    /** Ajouter le nombre de points de victoire au joueur. */
    private void ajouterPtsVictoire() {
        //---------------------------------------------------------------------------
        // Compter le nombre de points de victoires gagnés par le joueur à la fin du
        // tour
        //---------------------------------------------------------------------------

        // la combinaison du joueur courant
        Combinaison combinaisonJoueur = this.joueurCourant.getCombinaisonActive();

        // obtenir le nombre de points bonus
        int pointsBonus = combinaisonJoueur.finTour();

        int totalPoints = combinaisonJoueur.nombreGroupesPions() + pointsBonus;
        System.out.println(this.joueurCourant.getNom() + " gagne " + totalPoints + " ("
            + pointsBonus + " bonus)");
        this.joueurCourant.addPoints(totalPoints);
    }

    /**
     * Permet de passer au tour suivant.
     */
    @Override
    public void passerTour() {

        if (this.estEnCoursDePartie()) {

            // Actions de fin de tour
            this.ajouterPtsVictoire();
            this.joueurCourant.setEtat(JoueurState.DEBUT_TOUR);


            // Passage au tour suivant
            if (this.joueursIter.hasNext()) {
                this.setJoueurCourant(this.joueursIter.next());
            } else {
                this.joueursIter = this.joueurs.listIterator();
                this.setNumeroTour(this.getNumeroTour() + 1);
                this.setJoueurCourant(this.joueursIter.next());
            }
            if (this.getNumeroTour() > this.getNombreTourTotal()) {
                this.setEtat(JeuState.TERMINEE);
                System.out.println("Fin de la partie !");
            }
            if (joueurCourant.getEtat() != JoueurState.CHOIX_COMBINAISON) {
                debutTour();
            }
        } else {
            System.out.println("Partie non-commencé ou terminée. Abandon !");
            throw new PartiePasEnCoursException();
        }
    }



    //Se lance au debut du tour d'un joueur
    @Override
    public void debutTour() {
        System.out.println("\nDébut du tour de " + this.joueurCourant.getNom());
        Combinaison activComb = this.joueurCourant.getCombinaisonActive();
        if (activComb != null && activComb.getDeclin()) {
            this.joueurCourant.setEtat(JoueurState.CHOIX_COMBINAISON);
        } else if (this.joueurCourant.getEtat() == JoueurState.DEBUT_TOUR) {
            recupPions();
            // Active les effets de début de tour de la combinaison
            this.joueurCourant.getCombinaisonActive().debutTour();
        }

        this.joueurCourantObs.notifierChangement();
    }

    private void recupPions() {
        int pionsARecuperer = 0;

        // Récupère tout les pions sauf 1 sur chaque case possédé par le joueur.
        for (GroupePions pions : joueurCourant.getCombinaisonActive().getPions()) {
            pionsARecuperer += pions.getNombre() - 1;
            pions.getCase().setNewNombrePions(1);
        }

        // ajout des pions récupérés à la main du joueur
        joueurCourant.getCombinaisonActive().setNbPionsEnMain(
            pionsARecuperer + joueurCourant.getCombinaisonActive().getNbPionsEnMain());
        this.joueurCourantObs.notifierChangement();
    }

    /** Attaquer une case choisie.
     * @param maCase La case que l'on veut attaquer.
     */
    public void attaquerCase(Case maCase) {
        // robustesse
        if (maCase == null) {
            throw new IllegalArgumentException("maCase ne doit pas être vide.");
        }

        //checker si la case est atteignable (bordure etc)
        if (maCase.estAtteignable(joueurCourant)) {
            if (maCase.getPrenable()) { // Boolean et pas boolean
                if (joueurCourant.getEtat() == JoueurState.DEBUT_TOUR) {
                    joueurCourant.setEtat(JoueurState.ATTAQUE);
                }


                // Active les effets d'avant conquête de la combinaison.
                int reductionAttaque =
                    this.joueurCourant.getCombinaisonActive().avantConquete(maCase);

                Combinaison combinaisonActive = joueurCourant.getCombinaisonActive();
                int attaquants = Math.max(maCase.getNombreAttaquantNecessaire() - reductionAttaque, 1);
                int diff = combinaisonActive.getNbPionsEnMain() - attaquants;


                if (diff >= 0) {
                    // On déloge les pions adverses
                    GroupePions anciensPions = maCase.getGroupePions();
                    if (anciensPions != null) {
                        Combinaison ancienneCombinaison = anciensPions.getCombinaison();
                        if (anciensPions.getNombre() > 0) {

                            // Le joueur perd son territoire
                            ancienneCombinaison.getPions().remove(anciensPions);

                            // Le joueur récupère tout ses pions sauf 1
                            int newNbPions = ancienneCombinaison.getNbPionsEnMain()
                                + anciensPions.getNombre() - 1;
                            ancienneCombinaison.setNbPionsEnMain(newNbPions);

                            // Active les effets d'avant conquête de la combinaison.
                            ancienneCombinaison.apresConqueteAdverse(maCase);
                        }
                    }

                    // On place nos pions sur la case
                    GroupePions newGroupe = new GroupePions(combinaisonActive,
                        attaquants);
                    maCase.setNewPions(newGroupe);
                    combinaisonActive.setNbPionsEnMain(diff);
                    System.out.println("Pions en main : "
                        + combinaisonActive.getNbPionsEnMain());


                    // Active les effets d'après conquête de la combinaison
                    this.joueurCourant.getCombinaisonActive().apresConquete(maCase);

                } else if (diff >= -3) {
                    System.out.println("Pas assez de pions !");
                    System.out.println("Possédé : "
                        + combinaisonActive.getNbPionsEnMain() + "/"
                        + maCase.getNombreAttaquantNecessaire());
                    //lancer dé
                } else {
                    System.out.println("Pas assez de pions !");
                    System.out.println("Possédé : "
                        + combinaisonActive.getNbPionsEnMain() + "/"
                        + maCase.getNombreAttaquantNecessaire());
                    //exception conquête impossible pas assez de pions
                }

            } else {
                System.out.println("Case non prenable");
                //exception case non prenable (effet de pouvoir) (imprenable + paix).
            }
        } else {
            //exception case non atteignable (pas de pions sur une case voisine)
            System.out.println("Case non atteignable.");
        }
        this.joueurCourantObs.notifierChangement();
    }

    @Override
    public void placerPions(Case maCase, int nbPions) {
        // robustesse
        if (maCase == null || nbPions < 0) {
            throw new IllegalArgumentException("L'appel n'est pas correct.");
        }

        // On vérifie que la case appartient bien au joueur dont c'est le tour.
        Combinaison active = joueurCourant.getCombinaisonActive();
        int pionsEnMain = active.getNbPionsEnMain();

        if (maCase.getGroupePions().getCombinaison() == active) {
            if (nbPions <= pionsEnMain) {
                maCase.setNewNombrePions(maCase.getNombrepions() + nbPions);
                active.setNbPionsEnMain(pionsEnMain - nbPions);
            } else {
                System.out.println("Vous n'avez pas assez de pions en main");
            }
        } else {
            System.out.println("Cette case ne vous appartient pas");
        }
        this.joueurCourantObs.notifierChangement();
    }

    private void notifierModifs() {
        super.setChanged();
        super.notifyObservers();
        super.clearChanged();
    }

    @Override
    public void redeployement() {
        // Active les effets de la combinaison après l'attaque
        this.joueurCourant.getCombinaisonActive().reDeploiement();

        this.recupPions();
        this.joueurCourant.setEtat(JoueurState.REDEPLOYMENT);
        this.joueurCourantObs.notifierChangement();
    }

    @Override
    public JeuState getEtat() {
        return this.etat;
    }

}
