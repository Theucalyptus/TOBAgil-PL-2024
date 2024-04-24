package jeu.testsUnitaires;

import jeu.Case;
import jeu.Monde;

/**
 * TestMonde. Classe de Test de la classe monde.
 */
public class TestMonde {

    /** La précision des Comparaisons */
    public static double PRECISION = 0.0001;

    /**Le monde testé. */
    private Monde unMonde;

    /**Le nombre de colonne du plateau. */
    private int nbX;

    /**Le nombre de colonne du plateau. */
    private int nbY;

    @Before
    void setUp() {
        this.unMonde = new Monde();
    }

    @Test
    void testerConstructeurVide() {
        new Monde();
    }

    @Test
    void testerConstructeurDimension() {
        new Monde(3, 21);
    }

    @Test(expected=IllegalArgumentException.class)
    void testerRobustesseConstructeurDimensionPremierNegatif() {
        new Monde(-3, 5);
    }

    @Test(expected=IllegalArgumentException.class)
    void testerRobustesseConstructeurDimensionDeuxiemeNegatif() {
        new Monde(4, -1);
    }

    @Test(expected=IllegalArgumentException.class)
    void testerRobustesseConstructeurDimensionPremierNull() {
        new Monde(0, 12);
    }

    @Test(expected=IllegalArgumentException.class)
    void testerRobustesseConstructeurDimensionDeuxiemeNull() {
        new Monde(2, 0);
    }

    @Test
    void testerGetX() {
        assertEquals("La dimension selon Y du monde doit être " + this.nbX,
            this.unMonde.getDimX(), this.nbX, PRECISION);
    }


    @Test
    void testerGetY() {
        assertEquals("La dimension selon Y du monde doit être " + this.nbY,
            this.unMonde.getDimY(), this.nbY, PRECISION);
    }

}
