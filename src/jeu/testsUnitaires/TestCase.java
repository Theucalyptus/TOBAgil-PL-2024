package jeu.testsUnitaires;

import org.junit.*;

import jeu.Case;
import jeu.Combinaison;
import jeu.GroupePions;
import jeu.TypesRegions;
import jeu.TypesSymboles;
import jeu.batiments.TypesBatiments;
import jeu.peuples.Amazones;
import jeu.pouvoirs.Volants;

import static org.junit.Assert.*;

/**Tester les cases. */
public class TestCase {
    /**une Case. */
    private Case uneCase;
    /**une Case. */
    private Case uneCase2;
    /**10. */
    private static final int DIX = 10;
    /**Nombre Negatif. */
    private static final int NOMBRENEGATIF = -2;
    /**13. */
    private static final int TREIZE = 13;

    /**Mise en place du test. */
    @Before
    public void setUp() {
        this.uneCase = new Case(1, 1, TypesRegions.COLLINE, null, TypesSymboles.AUCUN, false);
        this.uneCase2 = new Case(1, 1, TypesRegions.COLLINE, null, TypesSymboles.AUCUN, true);

    }

    /**Tester le Constructeur. */
    @Test
    public void testerConstructeur() {
        new Case(1,
            2,
            TypesRegions.CHAMP,
            new GroupePions(
                new Combinaison(
                    new Amazones(),
                    new Volants()),
                DIX),
            TypesSymboles.AUCUN,
            true);
    }

    /**Tester la Robustesse du constructeur sur le premier argument. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseConstructeuriNegatif() {
        new Case(-1,
            2,
            TypesRegions.CHAMP,
            new GroupePions(
                new Combinaison(
                    new Amazones(),
                    new Volants()),
                DIX),
            TypesSymboles.AUCUN,
            false);
    }

    /**Tester la Robustesse du constructeur sur le deuxième argument. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseConstructeurjNégatif() {
        new Case(1,
            NOMBRENEGATIF,
            TypesRegions.CHAMP,
            new GroupePions(
                new Combinaison(
                    new Amazones(),
                    new Volants()),
                DIX),
            TypesSymboles.AUCUN,
            false);
    }

    /**Tester la Robustesse du Constructeur sur le Troisième argument. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseConstructeurTypeRegionNull() {
        new Case(1,
            2,
            null,
            new GroupePions(
                new Combinaison(
                    new Amazones(),
                    new Volants()),
                DIX),
            TypesSymboles.AUCUN,
            true);
    }

    /**Tester la Robustesse du Constructeur sur le Cinquième argument. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseConstructeurPionNull() {
        new Case(1,
            2,
            TypesRegions.COLLINE,
            new GroupePions(
                new Combinaison(
                    new Amazones(),
                    new Volants()),
                DIX),
            null,
            false);
    }

    /**Tester le setteur du nouveau groue de pions. */
    @Test
    public void testerSetNewPions() {
        GroupePions leNouveau = new GroupePions(new Combinaison(new Amazones(),
            new Volants()), TREIZE);
        this.uneCase.setNewpions(leNouveau);
        assertTrue(this.uneCase.getGroupePions() == leNouveau);
    }

    /**Tester la robustesse du setteur du pions. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseSetNewPions() {
        this.uneCase2.setNewpions(null);
    }

    /**Tester le setteur du type de Batiment. */
    @Test
    public void testerSetTypeBatient() {
        this.uneCase.setTypeBatiment(TypesBatiments.CAMPEMENT, 1);
        assertTrue(this.uneCase.getBatiment().containsKey(TypesBatiments.CAMPEMENT));
        assertTrue(this.uneCase.getBatiment().containsValue(1));
        assertFalse(this.uneCase.abscenceBatiment());
        assertTrue(this.uneCase2.abscenceBatiment());
    }

    /**Tester la Robustesse du setteur du type de batiment sur le premier argument. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseSetTypeBatiment1erArgumentNull() {
        this.uneCase2.setTypeBatiment(null, 1);
    }

    /**Tester la Robustesse du setteur du type de batiment sur le deuxième argument. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseSetTypeBatiment2eArgumentNull() {
        this.uneCase2.setTypeBatiment(TypesBatiments.CAMPEMENT, null);
    }

    /**Tester le setPrenable avec false. */
    @Test
    public void testerSetPrenableFalse() {
        this.uneCase.setPrenable(false);
        assertFalse(this.uneCase.getPrenable());
    }

    /**Tester le setPrenable avec true. */
    @Test
    public void testerSetPrenableTrue() {
        this.uneCase.setPrenable(true);
    }

    /**Tester la Robustesse de set prenable. */
    @Test
    public void testerRobustesseSetPrenable() {
        this.uneCase.setPrenable(null);
    }

    /**Tester le fait de retirer un batiment sur la case. */
    @Test
    public void testerRemoveBatiment() {
        this.uneCase.removeBatiment(TypesBatiments.CAMPEMENT);
        assertFalse(this.uneCase.getBatiment().containsKey(TypesBatiments.CAMPEMENT));
        assertFalse(this.uneCase.getBatiment().containsValue(1));
    }

    /**Tester la robustesse de retirer Batiment. */
    @Test
    public void testerRobustesseRemoveBatimentNull() {
        this.uneCase.removeBatiment(null);
    }

    /**Tester la robustesse de retirer Batiment si on essaye de retirer un batiment
     * qui n'est pas sur la case. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseRemoveBatimentPasDedans() {
        this.uneCase.removeBatiment(TypesBatiments.FORTERESSE);
    }

    /**Tester l'ajout de voisin. */
    @Test
    public void testerAjoutVoisins() {
        this.uneCase.ajoutVoisins(uneCase2);
    }

    /**Tester la robustesse de est atteignable. */
    public void testerRobustesseAjoutVoisins() {
        this.uneCase.ajoutVoisins(null);
    }

}
