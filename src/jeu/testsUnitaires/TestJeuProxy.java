package jeu.testsUnitaires;

import org.junit.*;

import jeu.JeuProxy;
import jeu.JeuReel;
import jeu.Joueur;
import jeu.Monde;
import jeu.exceptions.JoueurDejaDansLaPartieException;
import jeu.exceptions.MauvaisMondeException;
import jeu.exceptions.OperationInterditeException;
import jeu.exceptions.PartiePleineException;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Observer;


/**Tester le jeu. */
@SuppressWarnings("deprecation")
public class TestJeuProxy {

    /**La précision des tests d'égalité. */
    public static final double PRECISION = 0.0001;
    /**Un Jeu quelconque. */
    private JeuReel unJeu;
    /**Un proxy sur le jeu quelconque. */
    private JeuProxy unProxy;
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
    private JeuProxy unJeuA2Joueurs;
    /**Un jeu à 3 joueurs. */
    private JeuProxy unJeuA3Joueurs;
    /**Un jeu à 4 joueurs. */
    private JeuProxy unJeuA4Joueurs;
    /**Un jeu à 5 joueurs. */
    private JeuReel unJeuA5Joueurs;
    /**Un jeu où le monde est choisit. */
    private JeuProxy unJeuAvecUnMonde;
    /**Un monde pour cinq joueurs. */
    private Monde unMonde;

    // /**Un Observer sur le Nombre de Tour. */
    // private Observer unObserverSurTour;
    // /**Un Observer sur le JoueurCourant. */
    // private Observer unObserverSurJoueur;

    // Magic Number
    /**4. */
    private static final int QUATRE = 4;
    /**Cinq. */
    private static final int CINQ = 5;
    /**Neuf. */
    private static final int NEUF = 9;
    /**Huit. */
    private static final int HUIT = 8;
    /**Dix. */
    private static final int DIX = 10;

    /**Mise en place des tests. */
    @Before
    public void setUp() {
        // creer les jeux.
        this.unJeu = new JeuReel(CINQ);
        this.unJeuA5Joueurs = new JeuReel(CINQ);
        this.unJeuA5Joueurs.ajouterJoueur(new Joueur("succube", 0));
        this.unJeuA5Joueurs.ajouterJoueur(new Joueur("dragon", 0));
        this.unJeuA5Joueurs.ajouterJoueur(new Joueur("pixie", 0));
        this.unJeuA5Joueurs.ajouterJoueur(new Joueur("cerbere", 0));
        this.unJeuA5Joueurs.ajouterJoueur(new Joueur("wyvern", CINQ));

        // créer les proxys
        this.unProxy = new JeuProxy(this.unJeu);
    }

    /**Tester le constructeur avec un Jeu vide. */
    @Test
    public void testerConstructeurJeuVide() {
        new JeuProxy(new JeuReel());
    }

    /**Tester le constructeur avec un Jeu de Cinq Joueur. */
    @Test
    public void testerConstructeurJeuCinqJoueur() {
        new JeuProxy(this.unJeuA5Joueurs);
    }

    /**Tester la robustesse du Constructeur. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseConstructeur() {
        new JeuProxy(null);
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

    /**Tester la Robustesse d'ajouter Joueur dans une partie déjà pleine. */
    @Test(expected = OperationInterditeException.class)
    public void testerRobustesseAjouterJoueurTropDeJoueur() {
        this.unProxy.ajouterJoueur(new Joueur("Jean", 0));
    }

    /**Tester la robustesse d'ajouter Joueur. */
    @Test(expected = OperationInterditeException.class)
    public void testerRobustesseAjouterJoueurTropDeJoueur() {
        this.unProxy.ajouterJoueur(null);
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


    /**Tester le changement forcée du Monde. */
    @Test(expected = OperationInterditeException.class)
    public void testerSetMonde() {
        this.unProxy.setMonde(unMonde);
    }

    /**Tester la robustesse du changement de Monde avec une poignée nulle. */
    @Test(expected = OperationInterditeException.class)
    public void testerRobustesseSetMondeNull() {
        this.unProxy.setMonde(null);
    }

    /*
     /**Tester le setteur d'enCours avec True. *\/
     @Test
     public void testerSetEnCoursTrue() {
        this.unProxy.setEnCours(true);
        assertTrue(this.aJeu.estEnCoursDePartie());
    }

    /**Tester le setteur d'enCours avec False. *\/
    @Test
    public void testerSetEnCoursFalse() {
        this.aJeu.setEnCours(false);
        assertFalse(this.aJeu.estEnCoursDePartie());
    }
    */

    /**Tester set numéro tour. */
    @Test(expected = OperationInterditeException.class)
    public void testerSetNumeroTour() {
        this.unProxy.setNumeroTour(CINQ);
    }



    /**Tester l'ajout de d'observer sur le
     * Joueur Courant.
     */
    @Test(expected = OperationInterditeException.class)
    public void testerRobustesseAddJoueurCourant() {
        this.unProxy.addJoueurCourantObserver(null);
    }

    /**Tester la robustesse de l'ajout d'observer sur le
     * Nombre de Tour. */
    @Test(expected = OperationInterditeException.class)
    public void testerRobustesseAddNbTourObserver() {
        this.unProxy.addNbTourObserver(null);
    }

    /*
    /**Tester si réinitialiser Joueurs vide bien la liste de Joueur.
     *\/
    @Test
    public void testerReinitialiserJoueurs() {
        assertEquals("Le jeu doit avoir 5 joueurs avant le test.",
        this.unJeuA5Joueurs.getNombreJoueur(), 5, PRECISION);
        this.unJeuA5Joueurs.reinitialiserJoueurs();
        assertEquals("Le jeu doit avoir 0 joueur après la réinitialisation.",
        this.unJeuA5Joueurs.getNombreJoueur(), 5, PRECISION);
    }
    */

    /**Tester set monde. */
    @Test(expected = OperationInterditeException.class)
    public void testerSetMonde() {
        this.unProxy.setMonde(null);
    }

    /**Tester lancer partie. */
    @Test(expected = OperationInterditeException.class)
    public void testerLancerPartie() {
        this.unProxy.lancerPartie();
    }

    /**Tester passer Tour */
    @Test(expected = OperationInterditeException.class)
    public void testerPasserTour() {
        this.unProxy.passerTour();
    }

}
