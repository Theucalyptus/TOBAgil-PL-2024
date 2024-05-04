package ui;

import javax.swing.*;
import java.awt.*;


import jeu.Jeu;
import ui.selecteur.Selecteur;
import ui.views.CaseView;
import controleurs.*;

public class ActionsFenetre {

    private final JFrame fenetre;

    public ActionsFenetre(Jeu jeu, Selecteur<CaseView> selecteurCase) {

        this.fenetre = new JFrame("SmallWorld - Actions");
        Container contentPane = this.fenetre.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        // Ajout du controlleur pour le joueur
        contentPane.add(new ActionsJoueur(jeu, selecteurCase));
        contentPane.add(new ActionsJeu(jeu));

        this.fenetre.pack();
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
