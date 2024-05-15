package jeu.testsUnitaires;

import org.junit.*;

import jeu.Pioche;

import static org.junit.Assert.*;

public class TestPioche {
    //attributs
    /**Une pioche. */
    private Pioche unePioche;
    //Magic Numbers

    /**Mise en place du test. */
    @Before
    public void setUp() {
        this.unePioche = new Pioche();
    }

    /**Tester le Constructeur de la pioche. */
    @Test
    public void testerConstructeur() {
        new Pioche();
    }

    /**Tester la robustesse du Choix d'une Combinaison avec un nombre négatif. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseCombinaisonChoisitNegatif() {
        this.unePioche.combinaisonChoisit(NOMBRENEGATIF);
    }

    /**Tester la robustesse du Choix d'une Combinaison avec un nombre top grand. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseCombinaisonChoisitNegatif() {
        this.unePioche.combinaisonChoisit(Pioche.LONGUEURPIOCHE + 2);
    }
}
