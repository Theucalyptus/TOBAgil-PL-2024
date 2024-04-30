package jeu.testsUnitaires;

import org.junit.*;

import jeu.JeuReel;
import jeu.Joueur;
import jeu.exceptions.JoueurDejaDansLaPartieException;
import jeu.exceptions.PartiePleineException;

import static org.junit.Assert.*;

import java.util.List;


/**Tester le jeu */
public class TestJeuReel {

    /**La précision des tests d'égalité */
    public static final double PRECISION = 0.0001;
    /**Un Jeu quelconque. */
    private JeuReel aJeu;
    /**Un Joueur quelconque. */
    private Joueur unJoueur;
    /**Un premier joueur. */
    private Joueur j1;
    /**Un deuxième joueur. */
    private Joueur j2;
    /**Un troisième joueur. */
    private Joueur j3;
    /**Un quatrième joueur. */
    private Joueur j4;
    /**Un cinquième joueur. */
    private Joueur j5;
    /**Un jeu à 2 joueurs. */
    private JeuReel unJeuA2Joueurs;
    /**Un jeu à 3 joueurs. */
    private JeuReel unJeuA3Joueurs;
    /**Un jeu à 4 joueurs. */
    private JeuReel unJeuA4Joueurs;
    /**Un jeu à 5 joueurs. */
    private JeuReel unJeuA5Joueurs;

    /**Mise en place des tests. */
    @Before
    void setUp() {
        // creer une partie
        this.aJeu = new JeuReel();
        // creer un joueur
        this.unJoueur = new Joueur("Emanuel", 0);
        this.unJeuA5Joueurs = new JeuReel(5);
        // définition des joueurs
        this.j1 = new Joueur("Gabriel", 0);
        this.j2 = new Joueur("Valérie", 0);
        this.j3 = new Joueur("Anne", 0);
        this.j4 = new Joueur("Tony", 0);
        this.j5 = new Joueur("Yuji", 0);
        
        // ajout du j1
        this.unJeuA2Joueurs.ajouterJoueur(this.j1);
        this.unJeuA3Joueurs.ajouterJoueur(this.j1);
        this.unJeuA4Joueurs.ajouterJoueur(this.j1);
        this.unJeuA5Joueurs.ajouterJoueur(this.j1);

        // ajout du j2
        this.unJeuA2Joueurs.ajouterJoueur(this.j2);
        this.unJeuA3Joueurs.ajouterJoueur(this.j2);
        this.unJeuA4Joueurs.ajouterJoueur(this.j2);
        this.unJeuA5Joueurs.ajouterJoueur(this.j2);
        
        // ajout du j3
        this.unJeuA3Joueurs.ajouterJoueur(this.j3);
        this.unJeuA4Joueurs.ajouterJoueur(this.j3);
        this.unJeuA5Joueurs.ajouterJoueur(this.j3);

        // ajout de j4
        this.unJeuA4Joueurs.ajouterJoueur(this.j4);
        this.unJeuA5Joueurs.ajouterJoueur(this.j4);
        
        // ajout du j5
        this.unJeuA5Joueurs.ajouterJoueur(this.j5);

        // changement du status de la partie a 2 joueur : elle commence
        this.unJeuA2Joueurs.setEnCours(true);
    }
    
    /**Tester le constructeur. */
    @Test
    void testerConstructeurJeu() {
        JeuReel unJeu = new JeuReel();
        assertTrue("La fin du tour doit être mis a true en sortie du constructeur.",
            unJeu.estFinDeTour());
    }

    /** Tester le constructeur. */
    @Test
    void testerConstructeurJeu5Joueurs(){
        JeuReel unJeu = new JeuReel(5);
        assertTrue("La fin du tour doit être mis a true en sortie du constructeur.",
            unJeu.estFinDeTour());
        assertTrue("La partie ne doit pas être en cours", !this.estEnCoursDePartie());
        assertEquals("Le nombre de Tour total doit être de 0", this.getNombreTourTotal(), 0, PRECISION);
        assertTrue("Le numéro du tour doit être 1", this.testerGetNumeroTour(), 0, PRECISION);
    }

    /**Tester le constructeur avec 3 Joueurs. */
    @Test
    void testerConstructeurJeu3Joueurs() {
        JeuReel unJeu = new JeuReel(3);
        assertTrue("La fin du tour doit être mis a true en sortie du constructeur.",
            unJeu.estFinDeTour());
        assertTrue("La partie ne doit pas être en cours", !this.estEnCoursDePartie());
        assertEquals("Le nombre de Tour total doit être de 0", this.getNombreTourTotal(), 0, PRECISION);
        assertTrue("Le numéro du tour doit être 1", this.testerGetNumeroTour(), 0, PRECISION);
    }

    /**Tester le constructeur avec 4 joueurs. */
    @Test
    void testerConstructeurJeu4Joueurs() {
    JeuReel unJeu = new JeuReel(4);
        assertTrue("La fin du tour doit être mis a true en sortie du constructeur.",
            unJeu.estFinDeTour());
        assertTrue("La partie ne doit pas être en cours", !this.estEnCoursDePartie());
        assertEquals("Le nombre de Tour total doit être de 0", this.getNombreTourTotal(), 0, PRECISION);
        assertTrue("Le numéro du tour doit être 1", this.testerGetNumeroTour(), 0, PRECISION);
    }

    /**Tester la robustesse du constructeur avec 0 joueur. */
    @Test(expected=IllegalArgumentException.class)
    void testerRobustesseConstructeur0joueur() {
        new JeuReel(0);
    }

    /**Tester la robustesse du constructeur avec 1 joueur. */
    @Test(expected=IllegalArgumentException.class)
    void testerRobustesseConstructeur1joueur() {
        new JeuReel(1);
    }

    /**Tester la robustesse du constructeur avec un nombre negatif de joueur. */
    @Test(expected=IllegalArgumentException.class)
    void testerRobustesseConstructeurNombreNegatif() {
        new JeuReel(-1);
    }

    /**Tester la robustesse du constructeur avec plus de joueur qu'autoriser
     * dans le jeu.
     */
    @Test(expected=IllegalArgumentException.class)
    void testerRobustesseConstructeurTropJoueur() {
        new JeuReel(6);
    }

    /**Tester le getteur getMonde() */
    @Test
    void testerGetMonde() {
        Monde unMonde = this.aJeu.getMonde();
        assertEquals("La dimX doit être 0.", unMonde.getDimX(), 0);
        assertEquals("La dimY doit être 0.", unMonde.getDimY(), 0);
    }


    /**Tester le getteur de la liste de Joueurs. */
    @Test
    void testerGetJoueurs() {
        List<Joueur> js = this.unJeuA2Joueurs.getJoueurs();
        assertEquals("Le nombre de joueur doît être de 2",
            js.size(), 2);
    }


    /**Test le getteur de l'état du Tour : en cours ou fini. */
    @Test
    void testerEstFinDuTour() {
        assertTrue("la fin du Tour doit renvoie true",
            this.aJeu.estFinDeTour());
    }


    /**Tester le getteur du nombre de Tour de la partie. */
    @Test
    void testerGetNombreTourTotal() {
        assertEquals("Le jeu de base doit avoir un nombre de tour de 0",
            this.aJeu.getNombreTourTotal(), 0, PRECISION);
    }

    /**Tester le getteur du status de la partie : Encours, pasEnCours */
    @Test
    void testerEstEnCoursPartieNonCommencer() {
        assertTrue("Le status de la partie doit être false", !this.aJeu);
    }


    /**Tester le getteur du status de la partie : Encours, pasEnCours */
    @Test
    void testerEstEnCoursPartieCommencer() {
        assertTrue("Le status de la partie doit être true",
            this.unJeuA2Joueurs.estEnCoursDePartie());
    }

    /**Tester la commande Ajouter Joueur. */
    @Test
    void testerAjouterJoueur() {
        assertTrue(!this.aJeu.getJoueurs().contains(unJoueur));
        int av = this.aJeu.getNombreJoueur();
        this.aJeu.ajouterJoueur(unJoueur);
        assertEquals("Le nombre de Joueur doit augmenter.",
            this.aJeu.getNombreJoueur(), av + 1, PRECISION);
        assertTrue(this.aJeu.getJoueurs().contains(unJoueur));
    }

    /**Tester la Robustesse d'ajouterJoueur avec un joueur null */
    @Test(expected=IllegalArgumentException.class)
    void testerRobustesseAjouterJoueurNull() {
        this.aJeu.ajouterJoueur(null);
    }

    /**Tester la Robustesse d'ajouter Joueur dans une partie déjà pleine. */
    @Test(expected=PartiePleineException.class)
    void testerRobustesseAjouterJoueurTropDeJoueur() {
        this.unJeuA5Joueurs.ajouterJoueur(new Joueur("Jean", 0));
    }

    /**Tester l'actualisation du nombre de tour dans un Jeu a 2 joueurs. */
    @Test
    void testerMajNombreToursTotalsJeu2Joueurs() {
        this.unJeuA2Joueurs.majNombreToursTotals();
        assertEquals("Le jeu à 2 Joueurs doit avoir 10 tours.",
            this.unJeuA2Joueurs.getNombreTourTotal(), 10, PRECISION);
    }

    /**Tester l'actualision du nombre de tour dans un jeu a 3 joueurs. */
    @Test
    void testerMajNombreToursTotalsJeu3Joueurs() {
        this.unJeuA3Joueurs.majNombreToursTotals();
        assertEquals("Le jeu à 3 Joueurs doit avoir 9 tours.",
            this.unJeuA3Joueurs.getNombreTourTotal(), 9, PRECISION);
    }
    
    /**Tester l'actualisation du nombre de tour dans un jeu a 4 joueurs. */
    @Test
    void testerMajNombreToursTotalsJeu4Joueurs() {
        this.unJeuA4Joueurs.majNombreToursTotals();
        assertEquals("Le jeu à 4 Joueurs doit avoir 8 tours.",
            this.unJeuA4Joueurs.getNombreTourTotal(), 8, PRECISION);
    }

    /**Tester l'actualisation du nombre de tour dans un jeu a 5 joueurs. */
    @Test
    void testerMajNombreToursTotalsJeu5Joueurs() {
        this.unJeuA5Joueurs.majNombreToursTotals();
        assertEquals("Le jeu à 5 Joueurs doit avoir 8 tours.",
            this.unJeuA5Joueurs.getNombreTourTotal(), 8, PRECISION);
    }

    /**Tester le setteur de la fin du Tour. */
    @Test
    void testerSetFinDuTour() {
        this.aJeu.setFinDuTour();
        assertTrue("La fin du tour doit être mis a true.",
            this.aJeu.estFinDeTour());
    }


    /**Tester le setteurs du joueur courant. */
    @Test
    void testerSetJoueurCourant() {
        this.unJeuA2Joueurs.setJoueurCourant(this.j1);
        assertTrue("Le joueur mis en argument doit devenir le joueur courant s'il"
            + " fait partie de la partie.", this.unJeuA2Joueurs.getJoueurCourant() == this.j1);
    }

    @Test(expected=IllegalArgumentException.class)
    void testerRobustesseSetJoueurCourant() {
        this.unJeuA2Joueurs.setJoueurCourant(null);
    }

    @Test
    void testerReinitialiserJoueurs() {
        this.unJeuA5Joueurs.reinitialiserJoueurs();
        assertEquals("Le jeu ne devrait plus contenir de joueur.", 
            this.unJeuA5Joueurs.getNombreJoueur(), 0);
    }
}
