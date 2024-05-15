package ui;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import jeu.Jeu;
import ui.selecteur.Selecteur;
import ui.views.CaseView;
import ui.views.MainMondeView;

@SuppressWarnings("deprecation")
public class MainMondeFenetre implements Observer {

    /** Titre de la fenêtre. */
    private static final String NOM = "SmallWorld - Tour ";
    /** Largeur par défaut de la fenêtre. */
    private static final int DEFAULT_LARGEUR = 600;
    /** Hauteur par défaut de la fenêtre. */
    private static final int DEFAULT_HAUTEUR = 600;


    /** Vue du monde. */
    private final MainMondeView view;

    /** Le jeu affiché. */
    private final Jeu jeu;

    /** La fenêtre. */
    private JFrame fenetre;

    /**
     * Construit une fenêtre affichant le monde à partir du jeu avec un sélecteur de case.
     * @param jeu le jeu à afficher
     * @param selecteurCase le sélecteur permettant de choisir une case
     */
    public MainMondeFenetre(Jeu jeu, Selecteur<CaseView> selecteurCase) {
        this.jeu = jeu;
        this.jeu.ajouterObservateur(this);
        this.view = new MainMondeView(jeu.getMonde(), selecteurCase);

        this.fenetre = new JFrame(NOM);
        Container contenu = this.fenetre.getContentPane();
        contenu.setLayout(new BorderLayout());
        contenu.add(this.view, BorderLayout.CENTER);


        this.fenetre.pack();
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.fenetre.setSize(DEFAULT_LARGEUR, DEFAULT_HAUTEUR);
    }

    /**
     * Met à jour le titre de la fenêtre (nombre de tour).
     */
    private void updateTitre() {
        int nbTour = this.jeu.getNumeroTour();
        int nbTotalTour = this.jeu.getNombreTourTotal();
        this.fenetre.setTitle(NOM + nbTour + "/ " + nbTotalTour);
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        this.updateTitre();
    }

}
