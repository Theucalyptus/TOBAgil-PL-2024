package jeu.testsUnitaires;

import org.junit.*;

import jeu.JeuReel;
import jeu.Joueur;

import static org.junit.Assert.*;

import java.util.List;


/**Tester le jeu */
public class TestJeuReel {

    public static double PRECISION = 0.0001;
    private JeuReel aJeu;
    private Joueur unJoueur;
    private Joueur j1;
    private Joueur j2;
    private Joueur j3;
    private Joueur j4;
    private Joueur j5;
    private JeuReel unJeuA2Joueurs;
    private JeuReel unJeuA3Joueurs;
    private JeuReel unJeuA4Joueurs;
    private JeuReel unJeuA5Joueurs;

    @Before
    void setUp() {
        // creer une partie de 4 joueurs (Pascal, Emanuel, Gabriel, Yann)
        this.aJeu = new JeuReel();
        this.unJoueur = new Joueur("Emanuel", 0);
        unJeuA5Joueurs = new JeuReel();
        this.j1 = new Joueur("Gabriel", 0);
        this.unJeuA2Joueurs.ajouterJoueur(this.j1);
        this.unJeuA3Joueurs.ajouterJoueur(this.j1);
        this.unJeuA4Joueurs.ajouterJoueur(this.j1);
        this.unJeuA5Joueurs.ajouterJoueur(this.j1);
        this.j2 = new Joueur("Valérie", 0);
        this.unJeuA2Joueurs.ajouterJoueur(this.j2);
        this.unJeuA3Joueurs.ajouterJoueur(this.j2);
        this.unJeuA4Joueurs.ajouterJoueur(this.j2);
        this.unJeuA5Joueurs.ajouterJoueur(this.j2);
        this.j3 = new Joueur("Anne", 0);
        this.unJeuA3Joueurs.ajouterJoueur(this.j3);
        this.unJeuA4Joueurs.ajouterJoueur(this.j3);
        this.unJeuA5Joueurs.ajouterJoueur(this.j3);
        this.j4 = new Joueur("Tony", 0);
        this.unJeuA4Joueurs.ajouterJoueur(this.j4);
        this.unJeuA5Joueurs.ajouterJoueur(this.j4);
        this.j5 = new Joueur("Yuji", 0);
        this.unJeuA5Joueurs.ajouterJoueur(this.j5);
    }
    
    @Test
    void testerConstructeurJeu() {
        JeuReel unJeu = new JeuReel();
        assertTrue("La fin du tour doit être mis a true en sortie du constructeur.",
            unJeu.estFinDeTour());
    }

    @Test
    void testerAjouterJoueur() {
        assertTrue(!this.aJeu.getJoueurs().contains(unJoueur));
        int av = this.aJeu.getNombreJoueur();
        this.aJeu.ajouterJoueur(unJoueur);
        assertEquals("Le nombre de Joueur doit augmenter.",
            this.aJeu.getNombreJoueur(), av + 1, PRECISION);
        assertTrue(this.aJeu.getJoueurs().contains(unJoueur));
    }

    @Test(expected=IllegalArgumentException.class)
    void testerRobustesseAjouterJoueurNull() {
        this.aJeu.ajouterJoueur(null);
    }

    @Test(expected=IllegalCallerException.class)
    void testerRobustesseAjouterJoueurTropDeJoueur() {
        this.unJeuA5Joueur.ajouterJoueur(new Joueur("Jean", 0));
    }

    @Test
    void testerSetNombreTourJeu2Joueurs() {
        this.unJeuA2Joueurs.setNombreTour();
        assertEquals("Le jeu à 2 Joueurs doit avoir 10 tours.",
            this.unJeuA2Joueurs.getNombreTour(), 10, PRECISION);
    }

    @Test
    void testerSetNombreTourJeu3Joueurs() {
        this.unJeuA3Joueurs.setNombreTour();
        assertEquals("Le jeu à 3 Joueurs doit avoir 9 tours.",
            this.unJeuA3Joueurs.getNombreTour(), 9, PRECISION);
    }
        
    @Test
    void testerSetNombreTourJeu4Joueurs() {
        this.unJeuA4Joueurs.setNombreTour();
        assertEquals("Le jeu à 4 Joueurs doit avoir 8 tours.",
            this.unJeuA4Joueurs.getNombreTour(), 8, PRECISION);
    }

    @Test
    void testerSetNombreTourJeu5Joueurs() {
        this.unJeuA5Joueurs.setNombreTour();
        assertEquals("Le jeu à 5 Joueurs doit avoir 8 tours.",
            this.unJeuA5Joueurs.getNombreTour(), 8, PRECISION);
    }

    @Test
    void testerGetNombreTour() {
        assertEquals("Le jeu de base doit avoir un nombre de tour de 0",
            this.aJeu.getNombreTour(), 0, PRECISION);
    }

    @Test
    void testerGetJoueurs() {
        List<Joueur> js = this.unJeuA2Joueurs.getJoueurs();
        assertEquals("Le nombre de joueur doît être de 2",
            js.size(), 2);
    }

    @Test
    void testerSetFinDuTour() {
        this.aJeu.setFinDuTour();
        assertTrue("La fin du tour doit être mis a true.",
            this.aJeu.estFinDeTour());
    }

    @Test
    void testerEstFinDuTour() {
        assertTrue("la fin du Tour doit renvoie true",
            this.aJeu.estFinDeTour());
    }
}
