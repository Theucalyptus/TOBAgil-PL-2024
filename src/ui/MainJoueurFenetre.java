package ui;

import java.awt.*;
import javax.swing.*;

import jeu.Jeu;
import ui.views.MainJoueurView;

public class MainJoueurFenetre {

    // constantes de classe
    private static final String NOM = "SmallWorld - Joueur Courant";
    
    // composants de la gui
    private final MainJoueurView view = new MainJoueurView();

    private final Jeu jeu;

    public MainJoueurFenetre(Jeu jeu) {
        this.jeu = jeu;

        JFrame fenetre = new JFrame(NOM);
        Container contenu = fenetre.getContentPane();
        contenu.setLayout(new BorderLayout());
        contenu.add(this.view, BorderLayout.CENTER);


        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void update() {
        //this.view.setJoueur(jeu.getJoueurCourant());
        System.out.println("TODO : MainJoueurFenetre.update()");
    }

}