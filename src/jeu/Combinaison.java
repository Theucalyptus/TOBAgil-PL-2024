package jeu;
import java.util.List;

import jeu.peuples.Peuple;
import jeu.pouvoirs.Pouvoir;
import java.util.ArrayList;

public class Combinaison {


    //===============================================================
    //                            Attributs
    //===============================================================
    /** Le peuple constituant la combinaison. */
    private Peuple peuple;

    /** Le pouvoir constituant la combinaison. */
    private Pouvoir pouvoir;

    /** Le status de déclin de la combinaison. */
    private Boolean declin;

    /** La combinaison a-t-elle déja fais son premier tour. */
    private Boolean premierTour;

    /** Liste de groupe de pions de la combinaison. */
    private List<GroupePions> pions;

    /** Nombre de pions dans la main du joueur (0 en fin de tour). */
    private int nbPionsEnMain;

    //===============================================================
    //                        Constructeurs
    //===============================================================
    /**
     * Constructeur d'une combinaison.
     * @param peuple Le peuple constituant la combinaison.
     * @param pouvoir Le pouvoir constituant la combinaison.
     */
    public Combinaison(Peuple peuple, Pouvoir pouvoir) {
        this.peuple = peuple;
        this.pouvoir = pouvoir;
        this.declin = false;
        this.premierTour = true;
        this.pions = new ArrayList<>();
        this.nbPionsEnMain = peuple.getNbPions() + pouvoir.getNbPions();
    }

    //===============================================================
    //                          Getteurs
    //===============================================================
    /**
     * Donner le peuple de la combinaison.
     * @return Le peuple constituant la combinaison.
     */
    public Peuple getPeuple() {
        return this.peuple;
    }

    /**
     * Donner le pouvoir de la combinaison.
     * @return Le pouvoir constituant la combinaison.
     */
    public Pouvoir getPouvoir() {
        return this.pouvoir;
    }

    /**
     * Donner la situation de la combinaison.
     * @return vrai si la combinaison est en déclin.
     */
    public Boolean getDeclin() {
        return this.declin;
    }

    /**
     * Donner les groupes de Pions de la combinaison.
     * @return Les groupes de pions de la Combinaisons.
     */
    public List<GroupePions> getPions() {
        return this.pions;
    }

    /**
     * Obtenir le nombre de pions en mains.
     * @return Le nombre de pions en mains.
     */
    public int getNbPionsEnMain() {
        return this.nbPionsEnMain;
    }

    //===============================================================
    //                          Commandes
    //===============================================================

    /**
     * Changer le nombre de pions en mains de la Combinaisons.
     * @param newNbPions Le nouveau nombre de pion en mains.
     */
    public void setNbPionsEnMain(int newNbPions) {
        this.nbPionsEnMain = newNbPions;
    }

    /**
     * Ajouter un groupe de pions à la liste de la combinaison.
     * @param groupe le groupe de pion a ajouter.
     */
    public void addGroupe(GroupePions groupe) {
        this.pions.add(groupe);
    }

    /**
     * Supprimer un groupe de pions de la liste de la combinaison.
     * @param groupe le groupe de pion a ajouter.
     */
    public void supprGroupe(GroupePions groupe) {
        this.pions.remove(groupe);
    }

    /**
     * Permetre le passage en declin de la combinaison.
     */
    public void passageDeclin() {
        this.declin = true;
    }


    /**
     * Permetre d'initialiser le tour pour le peuple et le pouvoir.
     */
    public void debutTour() {
        this.peuple.debutTour();
        this.pouvoir.debutTour();
    }

    /**
     * Donner la reduction de pions pour conquérir la region.
     * @param regionAConquerir La case correspondant à la région a conquérir.
     * @return la redution obtenu.
     */
    public int avantConquete(Case regionAConquerir) {
        this.peuple.avantConquete(regionAConquerir);
        this.pouvoir.avantConquete(regionAConquerir);
        return (this.peuple.reductionAttaque + this.pouvoir.reductionAttaque);
    }

    /**
     * Permetre au peuple et pouvoir de prendre en compte un conquete.
     * @param regionConquise La case correspondant à la région conquise.
     */
    public void apresConquete(Case regionConquise) {
        this.peuple.apresConquete(regionConquise);
        this.pouvoir.apresConquete(regionConquise);
    }

    /**
     * Permetre au peuple et pouvoir de prendre en compte la perte d'une region.
     * @param regionConquise La case correspondant à la région perdu.
     */
    public void apresConqueteAdverse(Case regionConquise) {
        this.peuple.apresConqueteAdverse(regionConquise);
        this.pouvoir.apresConqueteAdverse(regionConquise);
    }

    /**
     * Permetre au peuple et pouvoir d'agir dans la phase de redéploiement.
     */
    public void reDeploiement() {
        this.peuple.finAttaque();
        this.pouvoir.finAttaque();
    }

    /**
     * Permetre d'obtenir les jetons de victoires bonus provenant du peuple et pouvoir.
     * @return Le bonus de jetons de victoires.
     */
    public int finTour() {
        this.peuple.finTour(this.declin);
        this.pouvoir.finTour(this.declin);
        this.premierTour = false;
        return (this.peuple.getNbJetons() + this.pouvoir.getNbJetons());
    }

    /** Permetre d'ajouter un ensemble de pion dans le groupe d'ensemble de pions.
     * @param lesPions L'ensemble de pions que l'on ajoute.
     */
    public void ajoutGroupesPions(GroupePions lesPions) {
        //on peut relever une erreur si il y a un problème au niveau de l'ajout
        if (!this.pions.add(lesPions)) {
            // List retourne toujours vrai donc cet environnement ne sera
            // jamais appelé
            throw new RuntimeException("Les pions n'ont pas été ajouté.");
        }
    }

    /** Permet d'obtenir le nombre de pions en main.
     * @return Le nombre de pions total.
     */
    public int nombrePions() {
        int nmbPions = 0;
        for (GroupePions e : this.pions) {
            nmbPions = e.getNombre();
        }
        return nmbPions;
    }

    /** Permet d'obtenir le nombre de groupes de pions.
     * @return Le nombre de Groupe de pions que possède la Combinaison.
    */
    public int nombreGroupesPions() {
        return this.pions.size();
    }
}
