package jeu;
import jeu.Specialite;
import jeu.peuples.Peuple;
import jeu.pouvoirs.Pouvoir;


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

    /** Ensemble de pions de la combinaison. */      
    private EnsemblePions pions;

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
        this.pions = null;
        this.premierTour = true;
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

    public EnsemblePions getPions() {
        return this.pions;
    }


    //===============================================================
    //                          Commandes
    //===============================================================

    /**
     * Permetre le passage en declin de la combinaison
     */
    public void passageDeclin() {
        this.declin = true;
    }


    /**
     * Permetre d'initialiser le tour pour le peuple et le pouvoir.
     */
    public void debutTour() {
        this.peuple.debutTour();
        this.peuple.debutTour();
    }

    /**
     * Donner la reduction de pions pour conquérir la region.
     * @param regionAConquerir La case correspondant à la région a conquérir.
     * @return la redution obtenu.
     */
    public int avantConquete(Case regionAConquerir) {
        this.peuple.avantConquete(regionAConquerir);
        this.peuple.avantConquete(regionAConquerir);
        return (this.peuple.reductionAttaque + this.pouvoir.reductionAttaque);
    }
    
    /**
     * Permetre au peuple et pouvoir de prendre en compte un conquete
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
     * Permetre au peuple et pouvoir d'agir dans la phase de redéploiement
     */
    public void reDeploiement() {
        this.peuple.finAttaque();
        this.pouvoir.finAttaque();
    }
    
    /**
     * Permetre d'obtenir les jetons de victoires bonus provenant du peuple et pouvoir.
     * @param enDeclin la boolean donnant la situation de la combinaison
     * @retun le bonus de jetons de victoires
     */
    public int finTour() {
        this.peuple.finTour(this.declin);
        this.pouvoir.finTour(this.declin);
        this.premierTour = false;
        return (this.peuple.getNbJetons() + this.pouvoir.getNbJetons());
    }

}