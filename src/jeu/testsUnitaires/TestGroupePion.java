package jeu.testsUnitaires;

import org.junit.*;

import jeu.Case;
import jeu.Combinaison;
import jeu.GroupePions;
import jeu.TypesRegions;
import jeu.TypesSymboles;
import jeu.peuples.Amazones;
import jeu.peuples.HommesRats;
import jeu.peuples.Mages;
import jeu.peuples.Sorciers;
import jeu.pouvoirs.AuxDeuxHeros;
import jeu.pouvoirs.DesForets;
import jeu.pouvoirs.Marins;
import jeu.pouvoirs.Volants;

import static org.junit.Assert.*;

public class TestGroupePion {

    /**Un groupe de Pion. */
    private GroupePions unGroupePions;
    /**Une case. */
    private Case uneCase;
    // magic Numbers.
    /** Un Nombre Negatif. */
    private static final int NOMBRENEGATIF = -4;
    /**4. */
    private static final int QUATRE = 4;
    /**La précision des tests d'égalité. */
    private static final double PRECISION = 0.001;

    /**Mise en place du test. */
    @Before
    public void setUp() {
        this.unGroupePions = new GroupePions(new Combinaison(new Amazones(),
            new Volants()), 10);
        this.uneCase = new Case(1, 1, TypesRegions.MARAIS, null,
            TypesSymboles.AUCUN, false);
    }

    /**Tester le Constructeur de la classe. */
    @Test
    public void testerConstructeur() {
        new GroupePions(new Combinaison(new Mages(), new AuxDeuxHeros()), 5);
    }

    /** Tester la robustesse du constructeur avec une Combinaison null. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseConstructeurCombinaisonNull() {
        new GroupePions(null, 12);
    }

    /**Tester la robustesse du Constructeur avec un nombre de Pions à 0. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseConstructeurZero() {
        new GroupePions(new Combinaison(new Sorciers(), new Marins()), 0);
    }

    /**Tester la robustesse du Constructeur avec un nombre de Pions négatif. */
    @test(expected = IllegalArgumentException.class)
    public void testerRobustesseConstructeurNegatif() {
        new GroupePions(new Combinaison(new HommesRats(),
            new DesForets()), NOMBRENEGATIF);
    }

    /**Tester le setteur du nombre de Pion. */
    @Test
    public void testerSetNombre() {
        this.unGroupePions.setNombre(QUATRE);
        assertEquals(this.unGroupePions.getNombre(), QUATRE, PRECISION);
    }

    /**Tester la robustesse de setNombre. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseSetNombreNegatif() {
        this.unGroupePions.setNombre(NOMBRENEGATIF);
    }

    /**Tester le setteur de Case. */
    @Test
    public void testerSetCase() {
        this.unGroupePions.setCase(this.uneCase);
        assertTrue(this.unGroupePions.getCase() == this.uneCase);
    }

    /**Tester le setteur de Case. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseSetCase() {
        this.unGroupePions.setCase(null);
    }

}
