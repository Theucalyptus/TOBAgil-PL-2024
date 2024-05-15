package jeu.testsUnitaires;

import org.junit.*;

import jeu.Combinaison;
import jeu.Joueur;
import jeu.peuples.Amazones;
import jeu.pouvoirs.Volants;

import static org.junit.Assert.*;

/** Tester la classe Joueurs. */
public class TestJoueur {

    /**Donne la précisions des test d'égalité. */
    public static final double PRECISION = 0.00001;

    // magic Numbers
    /**Nombre de point à ajouter durant le test. */
    private static final int POINTAAJOUTER = 10;

    /**Nombre de point à retirer durant le test. */
    private static final int POINTARETIRER = 5;

    /**Moins Dix-sept. */
    public static final int MOINSDIXSEPT = -17;

    /**Instance testé de Joueur. */
    private Joueur unJoueur;

    /**Une instance de Combianaison. */
    private Combinaison uneCombinaison;

    /**Mise en place du test, création des instances. */
    @Before
    public void setUp() {
        this.unJoueur = new Joueur("Paul", 0);
        this.uneCombinaison = new Combinaison(new Amazones(), new Volants());
    }

    /**Tester la robustesse du constructeur. */
    @Test(expected = IllegalArgumentException.class)
    public void testerConstructeurRobustesseNomVide() {
        new Joueur("", 0);
    }

    /**Tester la robustesse du Constructeur. */
    @Test(expected = IllegalArgumentException.class)
    public void testerConstructeurRobustesseNomNull() {
        new Joueur(null, 0);
    }

    /**Tester la robustesse du constructeur. */
    @Test(expected = IllegalArgumentException.class)
    public void testerConstructeurRobustessePointNegatif() {
        new Joueur("Marie", -1);
    }

    /**Tester l'accesseur de nom. */
    @Test
    public void testerGetNom() {
        assertTrue(this.unJoueur.getNom().equals("Paul"));
    }

    // /**Tester l'accesseur de Points. */
    // @Test
    // public void testerGetPoints() {
    //     assertEquals("Le nombre de points de être " + 0,
    //             0, this.unJoueur.getPoints(), PRECISION);
    // }

    /**Tester la commande d'ajout de points. */
    @Test
    public void testerAddPointsPositif() {
        int av = this.unJoueur.getPoints();
        this.unJoueur.addPoints(POINTAAJOUTER);
        int resultat = POINTAAJOUTER + av;
        assertEquals("Le nombre de points devrait être " + resultat,
                this.unJoueur.getPoints(), resultat, PRECISION);
    }

    /**Tester la robustesse d'ajout de point. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseAddPointsNegatif() {
        this.unJoueur.addPoints(-1);
    }

    /**Tester la commande de soustraction de point. */
    @Test
    public void testerSubPoints() {
        int av = this.unJoueur.getPoints();
        int resultat = av - POINTARETIRER;
        this.unJoueur.subPoints(POINTARETIRER);
        assertEquals("Le nombre de points devrait être " + resultat,
                this.unJoueur.getPoints(), resultat, PRECISION);
    }

    /**Tester la robustesse de la soustraction de point. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseSubPointsNegatif() {
        this.unJoueur.subPoints(MOINSDIXSEPT);
    }

    /**Tester la robustesse de la soustraction de points avec
     * plus que le capital du Joueur. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseSubPointsPlusQueCapital() {
        this.unJoueur.subPoints(this.unJoueur.getPoints() + 2);
    }

    // /**Tester le getteur de la Combianaison. */
    // public void testerGetCombinaison() {
    //     assertIsNull("Le Joueur en devrait pas avoir de combinaison encore.",
    //         this.unJoueur.getCombinaison());
    // }

    /**Tester le changement de combinaison. */
    @Test
    public void testerChangerCombinaisonActive() {
        int NombreDeCombinaisonEnDeclinAvant =
            this.unJoueur.getCombinaisonsDeclins().size();
        this.unJoueur.changerCombinaisonActive(this.uneCombinaison);
        assertTrue("La combinaison doit être Amazone + Volants",
            this.unJoueur.getCombinaisonActive() == this.uneCombinaison);
        assertEquals(this.unJoueur.getCombinaisonsDeclins().size(),
            NombreDeCombinaisonEnDeclinAvant + 1, PRECISION);
    }
}
