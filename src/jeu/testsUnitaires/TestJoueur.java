package jeu.testsUnitaires;

import org.junit.*;

import jeu.Joueur;

import static org.junit.Assert.*;

/** Tester la classe Joueurs. */
public class TestJoueur {

    /**Donne la précisions des test d'égalité. */
    public static final double PRECISION = 0.00001;

    /**Nombre de point à ajouter durant le test. */
    private static final int POINTAAJOUTER = 10;

    /**Nombre de point à retirer durant le test. */
    private static final int POINTARETIRER = 5;

    /**Instance testé de Joueur. */
    private Joueur unJoueur;

    /**Mise en place du test, création des instances. */
    @Before
    public void setUp() {
        this.unJoueur = new Joueur("Paul", 0);
    }

    /**Test la robustesse du constructeur. */
    @Test(expected = IllegalArgumentException.class)
    void testerConstructeurRobustesseNomVide() {
        new Joueur("", 0);
    }

    /**Test la robustesse du Constructeur. */
    @Test(expected = IllegalArgumentException.class)
    void testerConstructeurRobustesseNomNull() {
        new Joueur(null, 0);
    }

    /**Test la robustesse du constructeur. */
    @Test(expected = IllegalArgumentException.class)
    void testerConstructeurRobustessePointNegatif() {
        new Joueur("Marie", -1);
    }

    /**Test l'accesseur de nom. */
    @Test
    void testerGetNom() {
        assertTrue(this.unJoueur.getNom().equals("Paul"));
    }

    /**Test l'accesseur de Points. */
    @Test
    void testerGetPoints() {
        assertEquals("Le nombre de points de être " + 0,
                0, this.unJoueur.getPoints(), PRECISION);
    }

    /**Test la commande d'ajout de points. */
    @Test
    void testerAddPointsPositif() {
        int av = this.unJoueur.getPoints();
        this.unJoueur.addPoints(POINTAAJOUTER);
        int resultat = POINTAAJOUTER + av;
        assertEquals("Le nombre de points devrait être " + resultat,
                this.unJoueur.getPoints(), resultat, PRECISION);
    }

    /**Test la robustesse d'ajout de point. TODO : tester si on retire
     * plus de plus que le capital du joueur.
     */
    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseAddPointsNegatif() {
        this.unJoueur.addPoints(-1);
    }

    /**Test la commande de soustraction de point. */
    @Test
    void testerSubPoints() {
        int av = this.unJoueur.getPoints();
        int resultat = av - POINTARETIRER;
        this.unJoueur.subPoints(POINTARETIRER);
        assertEquals("Le nombre de points devrait être " + resultat,
                this.unJoueur.getPoints(), resultat, PRECISION);
    }

    /**Test la robustesse de la soustraction de point. */
    @Test(expected = IllegalArgumentException.class)
    void testerRubustesseSubPoints() {
        this.unJoueur.subPoints(-17);
    }
}
