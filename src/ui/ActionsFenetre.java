package ui;

import javax.swing.*;
import java.awt.*;

import jeu.Combinaison;
import jeu.JeuReel;
import ui.selecteur.Selecteur;
import ui.views.CaseView;
import controleurs.*;

public class ActionsFenetre {

    /** La fenêtre. */
    private final JFrame fenetre;

    /**
     * Construit une fenêtre des contrôleurs.
     * @param jeu Le jeu à contrôlé.
     * @param selecteurCase Le sélecteur de case.
     * @param selecteurCombinaison Le sélecteur de la combinaisons dans la pioche.
     */
    public ActionsFenetre(JeuReel jeu,
                Selecteur<CaseView> selecteurCase,
                Selecteur<Combinaison> selecteurCombinaison) {

        this.fenetre = new JFrame("SmallWorld - Actions");
        Container contentPane = this.fenetre.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        // Ajout du controlleur pour le joueur
        contentPane.add(new ActionsJeu(jeu));
        contentPane.add(new ActionsJoueur(jeu, selecteurCase, selecteurCombinaison));

        this.fenetre.pack();
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
