package ui;

import java.awt.*;
import javax.swing.*;

import jeu.Jeu;
import ui.views.MainMondeView;

public class MainMondeFenetre {

    // constantes de classe
    private static final String NOM = "SmallWorld";
    
    // composants de la gui
    private final MainMondeView view;

    private final Jeu jeu;

    //public MainGui(Jeu jeu) {
    public MainMondeFenetre(Jeu jeu) {
        this.jeu = jeu;
        this.view = new MainMondeView(jeu.getMonde());

        JFrame fenetre = new JFrame(NOM);
        Container contenu = fenetre.getContentPane();
        contenu.setLayout(new BorderLayout());
        contenu.add(this.view, BorderLayout.CENTER);


        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}