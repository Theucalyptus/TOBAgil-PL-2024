package jeu.testsUnitaires;

import org.junit.*;

import jeu.Combinaison;
import jeu.GroupePions;
import jeu.peuples.Amazones;
import jeu.peuples.Mages;
import jeu.pouvoirs.DesCavernes;
import jeu.pouvoirs.DesCollines;
import jeu.pouvoirs.Montes;
import jeu.pouvoirs.Volants;

import static org.junit.Assert.*;


/**Tester les Combinaisons. */
public class TestCombinaison {

    /**Une Combinaison. */
    private Combinaison uneCombinaison;

    /**Un Groupe de Pions. */
    private GroupePions unGroupePions = new GroupePions(
        new Combinaison(new Amazones(), new Volants()),
        0);

    /**La précisions des égalités. */
    private static final double PRECISION = 0.0001;

    /**Set up des tests. */
    @Before
    public void setUp() {
        this.uneCombinaison = new Combinaison(new Amazones(), new DesCollines());
    }

    /**Tester le Constructeur. */
    @Test
    public void testerConstructeur() {
        new Combinaison(new Amazones(), new Montes());
    }

    /**Tester la robustesse du Constructeur. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseConstructeur1erArgumentNull() {
        new Combinaison(null, new Montes());
    }

    /**Tester la robustesse du Constructeur de la classe. */
    public void testerRobustesseConstructeur2eArgumentNull() {
        new Combinaison(new Amazones(), null);
    }

    /**Tester le setteur du nombre de pions en mains. */
    @Test
    public void testerSetNbPionsEnMain() {
        this.uneCombinaison.setNbPionsEnMain(19);
        assertEquals(this.uneCombinaison.getNbPionsEnMain(), 19, PRECISION);
    }

    /*
    /**Tester la robustesse du setteur du nombre de pions en mains. *\/
    @Test(expected = )
    public void testerRobustesseSetNbPionsEnMainZero() {
        this.uneCombinaison.setNbPionsEnMain(0);
    }
    */

    /**Tester la robustesse du setteur du nombre de pions en mains. */
    @Test
    public void testerRobustesseSetNbPionsEnMainNegatif() {
        this.uneCombinaison.setNbPionsEnMain(-13);
    }

    /**Tester l'ajout d'un groupe de Pions. */
    @Test
    public void testerAddGroupe() {
        this.uneCombinaison.addGroupe(this.unGroupePions);
        assertTrue(this.uneCombinaison.getPions().contains(this.unGroupePions));
    }

    /**Tester la robustesse de l'ajout d'un groupe de pions. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseAddGroupe() {
        this.uneCombinaison.addGroupe(null);
    }


    /**Tester la suppression d'un groupe de Pion. */
    @Test
    public void testerSupprGroupe() {
        this.uneCombinaison.supprGroupe(this.unGroupePions);
        assertFalse(this.uneCombinaison.getPions().contains(this.unGroupePions));
    }

    /**Tester la robustesse de la suppression d'un groupe de pions avec une poignée
     * null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseSupprGroupeNull() {
        this.uneCombinaison.supprGroupe(null);
    }

    /**Tester la robustesse de la supression d'un groupe de pions. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseSupprGroupePasDedans() {
        this.uneCombinaison.supprGroupe(new GroupePions(
            new Combinaison(new Mages(), new DesCavernes()), 14));
    }

    /**Tester le passage en Declin. */
    @Test
    public void testerPassageDeclin() {
        this.uneCombinaison.passageDeclin();
        //this.uneCombinaison.estEnDeclin();
        assertTrue(this.uneCombinaison.getDeclin());
    }

    /**Tester la robustesse d'avant conquete.*/
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseAvantConquete() {
        this.uneCombinaison.avantConquete(null);
    }

    /**Tester la robustesse d'apres conquete. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseApresConquete() {
        this.uneCombinaison.apresConquete(null);
    }

    /**Tester la robustesse d'après Conquête adverse. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseApresConqueteAdverse() {
        this.uneCombinaison.apresConqueteAdverse(null);
    }
}
