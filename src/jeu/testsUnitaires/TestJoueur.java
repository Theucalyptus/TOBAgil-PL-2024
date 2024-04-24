package jeu.testsUnitaires;

import org.junit.*;

import jeu.Joueur;

import static org.junit.Assert.*;

/** Tester la classe Joueurs */
public class TestJoueur {

    public static double PRECISION = 0.00001;

    private Joueur unJoueur;

    @Before
    public void setUp() {
        this.unJoueur = new Joueur("Paul", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    void testerConstructeurRobustesseNomVide() {
        new Joueur("", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    void testerConstructeurRobustesseNomNull() {
        new Joueur(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    void testerConstructeurRobustessePointNegatif() {
        new Joueur("Marie", -1);
    }

    @Test
    void testerGetNom() {
        assertTrue(this.unJoueur.getNom().equals("Paul"));
    }

    @Test
    void testerGetPoints() {
        assertEquals("Le nombre de points de être " + 0,
                0, this.unJoueur.getPoints(), PRECISION);
    }

    @Test
    void testerAddPointsPositif() {
        int av = this.unJoueur.getPoints();
        int ajout = 10;
        this.unJoueur.addPoints(ajout);
        int resultat = ajout + av;
        assertEquals("Le nombre de points devrait être " + resultat,
                this.unJoueur.getPoints(), resultat, PRECISION);
    }

    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseAddPoints() {
        this.unJoueur.addPoints(-1);
    }

    @Test
    void testerSubPoints() {
        int av = this.unJoueur.getPoints();
        int enleve = 5;
        int resultat = av - enleve;
        this.unJoueur.subPoints(enleve);
        assertEquals("Le nombre de points devrait être " + resultat,
                this.unJoueur.getPoints(), resultat, PRECISION);
    }

    @Test(expected=IllegalArgumentException.class)
    void testerRubustesseSubPoints() {
        this.unJoueur.subPoints(-17);
    }


}