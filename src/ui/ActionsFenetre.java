package ui;

import javax.swing.*;
import java.awt.*;


import jeu.Jeu;
import controleurs.ActionsJoueur;

public class ActionsFenetre {
    
    private final JFrame fenetre;

    public ActionsFenetre(Jeu jeu) {

        ActionsJoueur act = new ActionsJoueur(jeu);
        
        this.fenetre = new JFrame("SmallWorld - Actions");
        Container contentPane = this.fenetre.getContentPane();
        contentPane.setLayout(new FlowLayout());

        contentPane.add(new ActionsJoueur(jeu));

        this.fenetre.pack();
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
