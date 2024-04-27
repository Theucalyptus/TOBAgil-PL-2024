package ui;

import java.awt.*;
import javax.swing.*;

import jeu.Jeu;
import ui.views.MainJoueurView;

public class MainJoueurFenetre {

    // constantes de classe
    private static final String NOM = "SmallWorld - Joueurs";
    
    // composants de la gui
    private final MainJoueurView view = new MainJoueurView();

    private final Jeu jeu;

    private JFrame fenetre;

    public MainJoueurFenetre(Jeu jeu) {
        this.jeu = jeu;

        this.fenetre = new JFrame(NOM);
        Container contenu = fenetre.getContentPane();
        contenu.setLayout(new BorderLayout());
        contenu.add(this.view, BorderLayout.CENTER);


        this.fenetre.pack();
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void update() {
        this.view.setJoueur(jeu.getJoueurCourant());
        this.fenetre.pack();
    }

}