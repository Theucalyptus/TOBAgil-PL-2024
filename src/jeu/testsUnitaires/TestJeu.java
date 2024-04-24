package jeu.testsUnitaires;

import org.junit.*;

import jeu.Jeu;
import jeu.JeuReel;
import jeu.Joueur;

import static org.junit.Assert.*;


/**Tester le jeu */
public class TestJeu {

    private Jeu aJeu;
    private Joueur unJoueur;

    @Before
    void setUp() {
        // creer une partie de 4 joueurs (Pascal, Emanuel, Gabriel, Yann)
        aJeu = new JeuReel();
        unJoueur = new Joueur();
    }
    
    @Test
    void TesterConstructeurJeu() {
        Jeu unJeu = new JeuReel();
    }

    @Test
    void TesterConstructeurJeu() {
        Jeu unJeu = new JeuReel();
    }

    @Test
    void TesterAjouterJoueur() {
        this.aJeu.ajouterJoueur(unJoueur);
    }

    @Test
    void TesterM() {
    }
    
}
