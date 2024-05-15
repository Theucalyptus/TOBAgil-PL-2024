package ui;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import jeu.Jeu;
import ui.views.MainJoueurView;

@SuppressWarnings("deprecation")
public class MainJoueurFenetre {

    /** Titre de la fenêtre. */
    private static final String NOM = "SmallWorld - Joueur Courant";

    /** Vue dans la fenêtre. */
    private final MainJoueurView view;

    /** La fenêtre. */
    private JFrame fenetre;

    /**
     * Construit une fenêtre affichant le joueur courant.
     * @param jeu le jeu dont on affiche les joueurs
     */
    public MainJoueurFenetre(Jeu jeu) {

        this.fenetre = new JFrame(NOM);
        this.view = new MainJoueurView(jeu);
        Container contenu = fenetre.getContentPane();
        contenu.setLayout(new BorderLayout());
        contenu.add(this.view, BorderLayout.CENTER);


        this.fenetre.pack();
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
