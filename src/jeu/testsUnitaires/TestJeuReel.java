package jeu.testsUnitaires;

import org.junit.*;

import jeu.JeuReel;
import jeu.Joueur;
import jeu.Monde;
import jeu.exceptions.JoueurDejaDansLaPartieException;
import jeu.exceptions.MauvaisMondeException;
import jeu.exceptions.PartiePleineException;

import static org.junit.Assert.*;

/**Tester le jeu. */
@SuppressWarnings("deprecation")
public class TestJeuReel {

    /**La précision des tests d'égalité. */
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
    /**Un jeu où le monde est choisit. */
    private JeuReel unJeuAvecUnMonde;
    /**Un monde pour cinq joueurs. */
    private Monde unMonde;

    // /**Un Observer sur le Nombre de Tour. */
    // private Observer unObserverSurTour;
    // /**Un Observer sur le JoueurCourant. */
    // private Observer unObserverSurJoueur;

    /**Cinq. */
    public static final int CINQ = 5;
    /**Neuf. */
    public static final int NEUF = 9;
    /**Huit. */
    public static final int HUIT = 8;
    /**Dix. */
    public static final int DIX = 10;

    /**Mise en place des tests. */
    @Before
    public void setUp() {
        // creer une partie de 4 joueurs (Pascal, Emanuel, Gabriel, Yann)
        this.aJeu = new JeuReel(CINQ);
        this.unJoueur = new Joueur("Emanuel", 0);
        unJeuA5Joueurs = new JeuReel(CINQ);
        this.unJeuAvecUnMonde = new JeuReel(CINQ);
        this.unMonde = new Monde(CINQ);
        this.unJeuAvecUnMonde.setMonde(this.unMonde);

        // this.unObserverSurJoueur = new Observer();
        // this.unObserverSurTour = new Observer();

        this.j1 = new Joueur("Gabriel", 0);
        this.unJeuA2Joueurs.ajouterJoueur(this.j1);
        this.unJeuA3Joueurs.ajouterJoueur(this.j1);
        this.unJeuA4Joueurs.ajouterJoueur(this.j1);
        this.unJeuA5Joueurs.ajouterJoueur(this.j1);
        this.j2 = new Joueur("Valérie", 0);
        this.unJeuA2Joueurs.ajouterJoueur(this.j2);
        this.unJeuA3Joueurs.ajouterJoueur(this.j2);
        this.unJeuA4Joueurs.ajouterJoueur(this.j2);
        this.unJeuA5Joueurs.ajouterJoueur(this.j2);
        this.j3 = new Joueur("Anne", 0);
        this.unJeuA3Joueurs.ajouterJoueur(this.j3);
        this.unJeuA4Joueurs.ajouterJoueur(this.j3);
        this.unJeuA5Joueurs.ajouterJoueur(this.j3);
        this.j4 = new Joueur("Tony", 0);
        this.unJeuA4Joueurs.ajouterJoueur(this.j4);
        this.unJeuA5Joueurs.ajouterJoueur(this.j4);
        this.j5 = new Joueur("Yuji", 0);
        this.unJeuA5Joueurs.ajouterJoueur(this.j5);
    }

    /**Tester le constructeur. */
    @Test
    public void testerConstructeurJeu() {
        new JeuReel();
    }

    /**Tester le constructeur. */
    @Test
    public void testerConstructeurJeuNombreJoueur() {
        new JeuReel(CINQ);
    }

    /**Tester le getteur du monde. */
    @Test
    public void testerGetMonde() {
        assertTrue("Le monde doit être la même poigné",
            this.unJeuAvecUnMonde.getMonde() == this.unMonde);
    }


    /**Tester le getteur de la liste de Joueurs. */
    @Test
    public void testerGetNombreJoueur() {
        int js = this.unJeuA2Joueurs.getNombreJoueur();
        assertEquals("Le nombre de joueur doît être de 2",
            js, 2);
    }

    /*
    /**Tester la commande Ajouter Joueur. *\/
    @Test
    public void testerAjouterJoueur() {
        assertTrue(!this.aJeu.getJoueurs().contains(unJoueur));
        int av = this.aJeu.getNombreJoueur();
        this.aJeu.ajouterJoueur(unJoueur);
        assertEquals("Le nombre de Joueur doit augmenter.",
        this.aJeu.getNombreJoueur(), av + 1, PRECISION);
        assertTrue(this.aJeu.getJoueurs().contains(unJoueur));
    }
    */

    /**Tester la Robustesse d'ajouterJoueur avec un joueur null. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseAjouterJoueurNull() {
        this.aJeu.ajouterJoueur(null);
    }

    /**Tester la Robustesse d'ajouter Joueur dans une partie déjà pleine. */
    @Test(expected = PartiePleineException.class)
    public void testerRobustesseAjouterJoueurTropDeJoueur() {
        this.unJeuA5Joueurs.ajouterJoueur(new Joueur("Jean", 0));
    }

    /*
    /**Tester l'actualisation du nombre de tour dans un Jeu a 2 joueurs. *\/
    @Test
    public void testerMajNombreToursTotalsJeu2Joueurs() {
        this.unJeuA2Joueurs.majNombreToursTotals();
        assertEquals("Le jeu à 2 Joueurs doit avoir 10 tours.",
            this.unJeuA2Joueurs.getNombreTourTotal(), DIX, PRECISION);
    }

    /**Tester l'actualision du nombre de tour dans un jeu a 3 joueurs. *\/
    @Test
    public void testerMajNombreToursTotalsJeu3Joueurs() {
        this.unJeuA3Joueurs.majNombreToursTotals();
        assertEquals("Le jeu à 3 Joueurs doit avoir 9 tours.",
            this.unJeuA3Joueurs.getNombreTourTotal(), NEUF, PRECISION);
    }

    /**Tester l'actualisation du nombre de tour dans un jeu a 4 joueurs. *\/
    @Test
    public void testerMajNombreToursTotalsJeu4Joueurs() {
        this.unJeuA4Joueurs.majNombreToursTotals();
        assertEquals("Le jeu à 4 Joueurs doit avoir 8 tours.",
            this.unJeuA4Joueurs.getNombreTourTotal(), HUIT, PRECISION);
    }

    /**Tester l'actualisation du nombre de tour dans un jeu a 5 joueurs. *\/
    @Test
    public void testerMajNombreToursTotalsJeu5Joueurs() {
        this.unJeuA5Joueurs.majNombreToursTotals();
        assertEquals("Le jeu à 5 Joueurs doit avoir 8 tours.",
            this.unJeuA5Joueurs.getNombreTourTotal(), HUIT, PRECISION);
    }

    /**Tester la robustesse de la mise à jour du nobre de tour totals. *\/
    @Test(expected = NombreJoueurIncorrectException.class)
    public void testerRobustesseMajNombreTourTotals() {
        this.aJeu.majNombreToursTotals();
    }
    */

    /**Tester le getteur du nombre de Tour. */
    @Test
    public void testerGetNombreTour() {
        assertEquals("Le jeu de base doit avoir un nombre de tour de 0",
            this.aJeu.getNombreTourTotal(), 0, PRECISION);
    }


    /**Tester le setteurs du joueur courant. */
    @Test
    public void testerSetJoueurCourant() {
        try {
            this.aJeu.ajouterJoueur(unJoueur);
        } catch (JoueurDejaDansLaPartieException e) {
            // Ne rien faire
        }
        this.aJeu.setJoueurCourant(unJoueur);
        assertTrue("Le joueur mis en argument doit devenir le joueur courant s'il"
            + " fait partie de la partie.", this.aJeu.getJoueurCourant() == unJoueur);
    }


    /**Tester le changement forcée du Monde. */
    @Test
    public void testerSetMonde() {
        this.aJeu.setMonde(unMonde);
        assertTrue("Le monde doit être le même",
            this.aJeu.getMonde() == this.unMonde);
    }

    /**Tester la robustesse du changement de Monde avec une poignée nulle. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseSetMondeNull() {
        this.aJeu.setMonde(null);
    }

    /**Tester la robustesse du changement du monde avec un monde
     * au mauvaise dimension. */
    @Test(expected = MauvaisMondeException.class)
    public void testerRobustesseSetMondeMauvaisMonde() {
        this.aJeu.setMonde(new Monde(CINQ));
    }

    /**Tester le setteur d'enCours avec True. */
    @Test
    public void testerSetEnCoursTrue() {
        this.aJeu.setEnCours(true);
        assertTrue(this.aJeu.estEnCoursDePartie());
    }

    /**Tester le setteur d'enCours avec True. */
    @Test
    public void testerSetEnCoursFalse() {
        this.aJeu.setEnCours(false);
        assertFalse(this.aJeu.estEnCoursDePartie());
    }

    /**Tester la robustesse de l'ajout d'observer sur le
     * Nombre de Tour. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseAddNbTourObserver() {
        this.aJeu.addNbTourObserver(null);
    }

    /**Tester la robustesse de l'ajout de d'observer sur le
     * Joueur Courant.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseAddJoueurCourant() {
        this.aJeu.addJoueurCourantObserver(null);
    }

    /**Tester si réinitialiser Joueurs vide bien la liste de Joueur.
    */
    @Test
    public void testerReinitialiserJoueurs() {
        assertEquals("Le jeu doit avoir 5 joueurs avant le test.",
            this.unJeuA5Joueurs.getNombreJoueur(), 5, PRECISION);
        this.unJeuA5Joueurs.reinitialiserJoueurs();
        assertEquals("Le jeu doit avoir 0 joueur après la réinitialisation.",
            this.unJeuA5Joueurs.getNombreJoueur(), 5, PRECISION);
    }
}
