package ui;

import java.awt.*;
import javax.swing.*;

import jeu.Jeu;

public class MainGui {

    // constantes de classe
    private static final String NOM = "SmallWorld";
    
    // composants de la gui
    private final MainBotttomBar botBar = new MainBotttomBar();
    private final MainTopBar topBar = new MainTopBar();
    private final MainMondeView view;

    public MainGui(Jeu jeu) {
        this.view = new MainMondeView(jeu.getMonde());

        JFrame fenetre = new JFrame(NOM);
        Container contenu = fenetre.getContentPane();
        contenu.setLayout(new BorderLayout());
        contenu.add(this.botBar, BorderLayout.SOUTH);
        contenu.add(this.topBar, BorderLayout.NORTH);
        contenu.add(this.view, BorderLayout.CENTER);

        int inner_size = 1000;
        int outer_size = inner_size + this.topBar.getHeight() + this.botBar.getHeight();

        fenetre.pack();
        fenetre.setSize(inner_size, outer_size);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}