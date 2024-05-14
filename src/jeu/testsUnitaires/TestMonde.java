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
    /**Le monde à 5 joueurs testé. */
    private Monde unMonde;
    /**Le nombre de colonne du plateau. */
    private int nbX;
    /**Le nombre de colonne du plateau. */
    private int nbY;
    /**Un monde pour 2 joueurs. */
    private Monde unMondeA2Joueurs;
    /**Un monde pour 3 joueurs. */
    private Monde unMondeA3Joueurs;
    /**Un monde pour 4 joueurs. */
    private Monde unMondeA4Joueurs;
    /**Un monde pour 5 joueurs. */
    private Monde unMondeA5Joueurs;


    // MagicNumber
    /**Un Nombre Negatif. */
    private static final int NOMBRENEGATIF = -3;
    /**2. */
    private static final int DEUX = 2;
    /**3. */
    private static final int TROIS = 3;
    /**4. */
    private static final int QUATRE = 4;
    /**5. */
    private static final int CINQ = 5;
    /**12 */
    private static final int DOUZE = 12;
    /**21. */
    private static final int VINGTETUN = 21;
    /**1000. */
    private static final int MILLE = 1000;


    /**Mise en place du test. */
    @Before
    public void setUp() {
        this.unMonde = new Monde(CINQ);
        this.unMondeA2Joueurs = new Monde(DEUX);
        this.unMondeA3Joueurs = new Monde(TROIS);
        this.unMondeA4Joueurs = new Monde(QUATRE);
        this.unMondeA5Joueurs = new Monde(CINQ);
    }


    // @Test
    // void testerConstructeurVide() {
    //     new Monde();
    // }

    // @Test
    // void testerConstructeurDimension() {
    //     new Monde(TROIS, VINGTETUN);
    // }

    // @Test(expected = IllegalArgumentException.class)
    // void testerRobustesseConstructeurDimensionPremierNegatif() {
    //     new Monde(-TROIS, CINQ);
    // }

    // @Test(expected = IllegalArgumentException.class)
    // void testerRobustesseConstructeurDimensionDeuxiemeNegatif() {
    //     new Monde(QUATRE, NOMBRENEGATIF);
    // }

    // @Test(expected = IllegalArgumentException.class)
    // void testerRobustesseConstructeurDimensionPremierNull() {
    //     new Monde(0, DOUZE);
    // }

    // @Test(expected = IllegalArgumentException.class)
    // void testerRobustesseConstructeurDimensionDeuxiemeNull() {
    //     new Monde(QUATRE, 0);
    // }

    // @Test
    // void testerCreerMonde2Joueurs() {
    //     Monde unAutreMonde = CreerMonde(2);
    //     int dimX = 5;
    //     int dimY = 5;
    //     assertEquals("Le nombre de colonne doit être " + dimX,
    //         unAutreMonde.getDimX(), 5, PRECISION);
    //     assertEquals("Le nombre de ligne doit être " + dimY,
    //         unAutreMonde.getDimY(), 5, PRECISION);
    // }

    // @Test
    // void testerCreerMonde3Joueurs() {
    //     Monde unAutreMonde = CreerMonde(3);
    //     int dimX = 6;
    //     int dimY = 6;
    //     assertEquals("Le nombre de colonne doit être " + dimX,
    //         unAutreMonde.getDimX(), 6, PRECISION);
    //     assertEquals("Le nombre de ligne doit être " + dimY,
    //         unAutreMonde.getDimY(), 6, PRECISION);
    // }

    // @Test
    // void testerCreerMonde4Joueurs() {
    //     Monde unAutreMonde = CreerMonde(4);
    //     int dimX = 7;
    //     int dimY = 7;
    //     assertEquals("Le nombre de colonne doit être " + dimX,
    //         unAutreMonde.getDimX(), 6, PRECISION);
    //     assertEquals("Le nombre de ligne doit être " + dimY,
    //         unAutreMonde.getDimY(), 6, PRECISION);
    // }

    // @Test
    // void testerCreerMonde5Joueurs() {
    //     Monde unAutreMonde = CreerMonde(5);
    //     int dimX = 8;
    //     int dimY = 8;
    //     assertEquals("Le nombre de colonne doit être " + dimX,
    //         unAutreMonde.getDimX(), 6, PRECISION);
    //     assertEquals("Le nombre de ligne doit être " + dimY,
    //         unAutreMonde.getDimY(), 6, PRECISION);
    // }


    // @Test(expected = IllegalArgumentException.class)
    // void testerRobustesseCreerMondeZero() {
    //     CreerMonde(0);
    // }

    // @Test(expected = IllegalArgumentException.class)
    // void testerRobustesseCreerMondePlusQueCinq() {
    //     CreerMonde(6);
    // }

    /**Tester le Constructeur 2 Joueurs. */
    @Test
    public void testerConstructeur2Joueurs() {
        new Monde(DEUX);
    }

    /** Tester le constructeur 3 Joueurs. */
    @Test
    public void testerConstructeur3Joueurs() {
        new Monde(TROIS);
    }

    /**Tester le Constructeur 4 Joueurs. */
    @Test
    public void testerConstructeur4Joueurs() {
        new Monde(QUATRE);
    }

    /**Tester le Constructeur 5 Joueurs. */
    @Test
    public void testerConstructeur5Joueurs() {
        new Monde(CINQ);
    }

    /**Tester la robustesse du Constructeur avec 1 Joueur. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseConstructeur1Joueur() {
        new Monde(1);
    }

    /**Tester la robustesse du Constructeur avec 0 joueur. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseConstructeur0Joueur() {
        new Monde(0);
    }

    /**Tester la robustesse du Constructeur avec un nombre négatif de joueur. */
    @Test(expected = IllegalArgumentException.class)
    public void testerRobustesseConstructeurNombreNegatif() {
        new Monde(NOMBRENEGATIF);
    }

    /**Tester le getteurs d'une case. */
    @Test
    public void testerGetUneCase() {
        int x = 1;
        int y = 2;
        int dim = 2;
        Case uneCase = this.unMonde.getCase(x, y);
        List<Integer> co = uneCase.getCoordonnees();
        assertEquals("La listes des coordonnée doit avoir une dimension de " + dim,
            co.size(), DEUX, PRECISION);
        assertEquals("La première coordonnée doit être " + x, co.get(0), x, PRECISION);
        assertEquals("La deuxième coordonnée doit être " + y, co.get(1), y, PRECISION);
    }

    /**Tester le getteur d'une case sur un monde a 2 joueurs. */
    @Test
    public void testerGetUneCase2Joueurs() {
        Case laCase = this.unMondeA2Joueurs.getCase(DEUX, TROIS);
        List<Integer> co = laCase.getCoordonnees();
        assertEquals("La listes des coordonnée doit avoir une dimension de " + DEUX,
            co.size(), DEUX, PRECISION);
        assertEquals("La première coordonnée doit être " + DEUX, co.get(0), DEUX, PRECISION);
        assertEquals("La deuxième coordonnée doit être " + TROIS, co.get(1), TROIS, PRECISION);
    }

    /**Tester le getteur d'une case sur un monde a 3 joueurs. */
    @Test
    public void testerGetUneCase3Joueurs() {
        Case laCase = this.unMondeA3Joueurs.getCase(DEUX, TROIS);
        List<Integer> co = laCase.getCoordonnees();
        assertEquals("La listes des coordonnée doit avoir une dimension de " + DEUX,
            co.size(), DEUX, PRECISION);
        assertEquals("La première coordonnée doit être " + DEUX, co.get(0), DEUX, PRECISION);
        assertEquals("La deuxième coordonnée doit être " + TROIS, co.get(1), TROIS, PRECISION);
    }


    /**Tester le getteur d'une case sur un monde a 4 joueurs. */
    @Test
    public void testerGetUneCase4Joueurs() {
        Case laCase = this.unMondeA4Joueurs.getCase(DEUX, TROIS);
        List<Integer> co = laCase.getCoordonnees();
        assertEquals("La listes des coordonnée doit avoir une dimension de " + DEUX,
            co.size(), DEUX, PRECISION);
        assertEquals("La première coordonnée doit être " + DEUX, co.get(0), DEUX, PRECISION);
        assertEquals("La deuxième coordonnée doit être " + TROIS, co.get(1), TROIS, PRECISION);
    }

    /**Tester le getteur d'une case sur un monde a 5 joueurs. */
    @Test
    public void testerGetUneCase5Joueurs() {
        Case laCase = this.unMondeA5Joueurs.getCase(DEUX, TROIS);
        List<Integer> co = laCase.getCoordonnees();
        assertEquals("La listes des coordonnée doit avoir une dimension de " + DEUX,
            co.size(), DEUX, PRECISION);
        assertEquals("La première coordonnée doit être " + DEUX, co.get(0), DEUX, PRECISION);
        assertEquals("La deuxième coordonnée doit être " + TROIS, co.get(1), TROIS, PRECISION);
    }


    /**Tester la robustesse de getCase avec un Nombre négatif en abscisse. */
    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseGetCaseXNegatif() {
        this.unMonde.getCase(NOMBRENEGATIF, 1);
    }

    /**Tester la robustesse de getCase avec un nombre négatif en ordonnée. */
    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseGetCaseYNegatif() {
        this.unMonde.getCase(1, NOMBRENEGATIF);
    }

    /**Tester la robustesse de Get Case avec un Nombre trop grand en premier argument. */
    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseGetCaseXTropGrand() {
        this.unMonde.getCase(MILLE, 1);
    }

    /**Tester la robustesse de GetCase avec un Nombre trop grand en deuxième argument. */
    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseGetCaseYTropGrand() {
        this.unMonde.getCase(1, MILLE);
    }

    /**Tester la robustesse de getCase avec 0 en premier argument. */
    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseGetCaseXZero() {
        this.unMonde.getCase(0, 1);
    }


    /**Tester la robustesse de getCase avec 0 en deuxième argument. */
    @Test(expected = IllegalArgumentException.class)
    void testerRobustesseGetCaseYZero() {
        this.unMonde.getCase(1, 0);
    }
}
