package ui;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import jeu.Jeu;
import ui.views.MainMondeView;

@SuppressWarnings("deprecation")
public class MainMondeFenetre implements Observer {

    // constantes de classe
    private static final String NOM = "SmallWorld - Tour ";
    private static final int DEFAULT_LARGEUR = 600;
    private static final int DEFAULT_HAUTEUR = 600;

    
    // composants de la gui
    private final MainMondeView view;

    // modèle
    private final Jeu jeu;

    // fenetre
    private JFrame fenetre;

    //public MainGui(Jeu jeu) {
    public MainMondeFenetre(Jeu jeu) {
        this.jeu = jeu;
        this.jeu.addNbTourObserver(this);
        this.view = new MainMondeView(jeu.getMonde());

        this.fenetre = new JFrame(NOM);
        Container contenu = this.fenetre.getContentPane();
        contenu.setLayout(new BorderLayout());
        contenu.add(this.view, BorderLayout.CENTER);


        this.fenetre.pack();
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.fenetre.setSize(DEFAULT_LARGEUR, DEFAULT_HAUTEUR);
    }


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