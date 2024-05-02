package jeu.testsUnitaires;

import java.util.List;

import jeu.Case;
import jeu.Monde;

/**
 * TestMonde. Classe de Test de la classe monde.
 */
public class TestMonde {

    /** La précision des Comparaisons. */
    public static final double PRECISION = 0.0001;

    /**Le monde testé. */
    private Monde unMonde;

    /**Le nombre de colonne du plateau. */
    private int nbX;

    /**Le nombre de colonne du plateau. */
    private int nbY;

    // MagicNumber
    /**Trois. */
    public static final int TROIS = 3;
    /**21. */
    public static final int VINGTETUN = 21;
    /**5. */
    public static final int CINQ = 5;


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
        new Monde(TROIS, VINGTETUN);
    }

    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseConstructeurDimensionPremierNegatif() {
        new Monde(-TROIS, CINQ);
    }

    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseConstructeurDimensionDeuxiemeNegatif() {
        new Monde(4, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseConstructeurDimensionPremierNull() {
        new Monde(0, 12);
    }

    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseConstructeurDimensionDeuxiemeNull() {
        new Monde(2, 0);
    }

    @Test
    void testerCreerMonde2Joueurs() {
        Monde unAutreMonde = CreerMonde(2);
        int dimX = 5;
        int dimY = 5;
        assertEquals("Le nombre de colonne doit être " + dimX,
            unAutreMonde.getDimX(), 5, PRECISION);
        assertEquals("Le nombre de ligne doit être " + dimY,
            unAutreMonde.getDimY(), 5, PRECISION);
    }

    @Test
    void testerCreerMonde3Joueurs() {
        Monde unAutreMonde = CreerMonde(3);
        int dimX = 6;
        int dimY = 6;
        assertEquals("Le nombre de colonne doit être " + dimX,
            unAutreMonde.getDimX(), 6, PRECISION);
        assertEquals("Le nombre de ligne doit être " + dimY,
            unAutreMonde.getDimY(), 6, PRECISION);
    }

    @Test
    void testerCreerMonde4Joueurs() {
        Monde unAutreMonde = CreerMonde(4);
        int dimX = 7;
        int dimY = 7;
        assertEquals("Le nombre de colonne doit être " + dimX,
            unAutreMonde.getDimX(), 6, PRECISION);
        assertEquals("Le nombre de ligne doit être " + dimY,
            unAutreMonde.getDimY(), 6, PRECISION);
    }

    @Test
    void testerCreerMonde5Joueurs() {
        Monde unAutreMonde = CreerMonde(5);
        int dimX = 8;
        int dimY = 8;
        assertEquals("Le nombre de colonne doit être " + dimX,
            unAutreMonde.getDimX(), 6, PRECISION);
        assertEquals("Le nombre de ligne doit être " + dimY,
            unAutreMonde.getDimY(), 6, PRECISION);
    }


    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseCreerMondeZero() {
        CreerMonde(0);
    }

    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseCreerMondePlusQueCinq() {
        CreerMonde(6);
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

    @Test
    void testerGetCaseUnDeux() {
        int x = 1;
        int y = 2;
        int dim = 2;
        Case uneCase = this.unMonde.getCase(x, y);
        List<Integer> co = uneCase.getCoordonnees();
        assertEquals("La listes des coordonnée doit avoir une dimension de " + dim,
            co.size(), 2, PRECISION);
        assertEquals("La première coordonnée doit être " + x, co.get(0), x, PRECISION);
        assertEquals("La deuxième coordonnée doit être " + y, co.get(1), y, PRECISION);
    }

    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseGetCaseXNegatif() {
        this.unMonde.getCase(-1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseGetCaseYNegatif() {
        this.unMonde.getCase(1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseGetCaseXTropGrand() {
        this.unMonde.getCase(1000, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseGetCaseYTropGrand() {
        this.unMonde.getCase(1, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseGetCaseXZero() {
        this.unMonde.getCase(0, 1);
    }
}
