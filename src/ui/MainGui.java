package ui;

import java.awt.*;
import javax.swing.*;

import jeu.Jeu;

public class MainGui {

    private static final String NOM = "SmallWorld";

    public MainGui(Jeu jeu) {
        JFrame fenetre = new JFrame(NOM);

        Container contenu = fenetre.getContentPane();
        contenu.setLayout(new BorderLayout());

        contenu.add(new MainBotttomBar(), BorderLayout.SOUTH);
        contenu.add(new MainTopBar(), BorderLayout.NORTH);

        MainMondeView mondeView = new MainMondeView();
        contenu.add(mondeView, BorderLayout.CENTER);

    
        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}